package com.example.boss.mausam;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boss.mausam.Data.Channel;
import com.example.boss.mausam.Data.Item;
import com.example.boss.mausam.Service.WeatherServiceCallback;
import com.example.boss.mausam.Service.YahooWeatherService;

public class MainActivity extends AppCompatActivity implements WeatherServiceCallback {


    private ImageView weatherInfo;
    private TextView temp;
    private TextView condition;
    private TextView locationT;
    private EditText input;

    private YahooWeatherService service;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherInfo = (ImageView)findViewById(R.id.weatherIcon);
        temp = (TextView)findViewById(R.id.t1);
        condition = (TextView)findViewById(R.id.t2);
        locationT = (TextView)findViewById(R.id.t3);
        input =(EditText)findViewById(R.id.inp);
        Button b = (Button)findViewById(R.id.sub);
        String val = input.getText().toString();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        service =new YahooWeatherService(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String val = input.getText().toString();

            }
        });

        dialog =new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.show();
        service.reFreshWeather("Surat,India");
    }

    @Override
    public void serviceSuccess(Channel channel) {

        dialog.hide();

        Item item = channel.getItem();
        int resourceId =getResources().getIdentifier("drawable/icon_"+ item.getCondition().getCode(),null,getPackageName());

        //
        /*@SuppressWarnings("depraction")
                Drawable weatherIconDrawble =getResources().getDrawable(resourceId);*/

        Drawable weatherIconDrawble = getResources().getDrawable(resourceId,null);

        weatherInfo .setImageDrawable(weatherIconDrawble);

        temp.setText(item.getCondition().getTemperature() + "\u00B0"+channel.getUnits().getTemperature());
        condition.setText(item.getCondition().getDescription());
        locationT.setText(service.getLocation());

    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
