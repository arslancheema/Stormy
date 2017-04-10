package com.example.aarshad.stormy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String apiKey  = "70fa9c06094f0d6ac2606ebb569d1810";
        double latitude = 37.8267 ;
        double longitude = -122.4233;
        String forecastURL = "https://api.darksky.net/forecast/" + apiKey + "/" + latitude + "," + longitude;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(forecastURL)
                .build();
        Call call  =  client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                    if (response.isSuccessful()){
                        Log.v(TAG, "Response Body "+ response.body().string());
                    } else {
                        alertUserAboutError();
                    }
            }
        });

        Log.v(TAG,"main UI code is running");



    }

    private void alertUserAboutError() {
    }
}
