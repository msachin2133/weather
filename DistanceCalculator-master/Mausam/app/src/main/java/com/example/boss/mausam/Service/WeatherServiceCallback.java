package com.example.boss.mausam.Service;

import com.example.boss.mausam.Data.Channel;

/**
 * Created by boss on 1/12/2018.
 */

public interface WeatherServiceCallback {

    void serviceSuccess(Channel channel);

    void serviceFailure(Exception exception);
}
