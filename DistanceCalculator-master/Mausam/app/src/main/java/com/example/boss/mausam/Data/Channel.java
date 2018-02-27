package com.example.boss.mausam.Data;

import org.json.JSONObject;

/**
 * Created by boss on 1/12/2018.
 */

public class Channel implements JSONPopulator {
    private Units units;
    private Item item;

    public Units getUnits() {
        return units;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public void populate(JSONObject data) {
        units =new Units();
        units.populate(data.optJSONObject("units"));

        item =new Item();
        item.populate(data.optJSONObject("item"));

    }
}
