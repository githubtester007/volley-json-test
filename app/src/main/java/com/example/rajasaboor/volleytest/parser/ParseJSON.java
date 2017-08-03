package com.example.rajasaboor.volleytest.parser;

import android.content.Context;
import android.util.Log;

import com.example.rajasaboor.volleytest.model.Model;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rajaSaboor on 8/3/2017.
 */

public class ParseJSON {
    private static final String TAG = ParseJSON.class.getSimpleName();
    private final String rawData;
    private Context context;

    public ParseJSON(String rawData, Context context) {
        this.rawData = rawData;
        this.context = context;
    }

    public void start() {
        try {
            JSONObject parent = new JSONObject(rawData);
            JSONObject child = parent.getJSONObject("feed");
            JSONArray array = child.getJSONArray("entry");
            Gson gson = new Gson();

            for (int i = 0; i < array.length(); i++) {
                JSONObject temp = array.getJSONObject(i);
                Model model = gson.fromJson(temp.getJSONObject("im:name").toString(), Model.class);
                Log.d(TAG, "start: Temp --> " + model.getName());

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
