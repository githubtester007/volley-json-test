package com.example.rajasaboor.volleytest.downloader;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by rajaSaboor on 8/3/2017.
 */

public class DownloadRawData {
    private static final String TAG = DownloadRawData.class.getSimpleName();
    private final String downloadURL;
    private Context context;
    private IOnDownloadComplete downloadCompleteListener;

    public DownloadRawData(String downloadURL, Context context, IOnDownloadComplete downloadCompleteListener) {
        this.downloadURL = downloadURL;
        this.context = context;
        this.downloadCompleteListener = downloadCompleteListener;
    }

    public void start() {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(downloadURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: start");

                if (downloadCompleteListener != null) {
                    downloadCompleteListener.onDownloadCompleteListener(response);
                }
                Log.d(TAG, "onResponse: end");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: start");
                Log.d(TAG, "onErrorResponse: error ---> " + error.getMessage());
                Log.d(TAG, "onErrorResponse: end");
            }
        });

        requestQueue.add(request);
    }

    public interface IOnDownloadComplete {
        void onDownloadCompleteListener(String downloadedData);
    }
}
