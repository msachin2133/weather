package com.example.boss.mausam.Data;

import org.json.JSONObject;

/**
 * Created by boss on 1/12/2018.
 */

public class Units implements JSONPopulator {
    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    @Override
    public void populate(JSONObject data) {

        temperature =data.optString("temperature");

    }
}
