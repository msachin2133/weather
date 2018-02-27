package com.example.boss.mausam.Data;

import org.json.JSONObject;

/**
 * Created by boss on 1/12/2018.
 */

public class Item implements JSONPopulator {

    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void populate(JSONObject data) {

        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));

    }
}
