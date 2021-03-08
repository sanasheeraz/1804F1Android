package com.example.splashscreenwithsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread timer=new Thread()
        {
          public void run()
          {
              try {
                  sleep(8000);
              }catch (Exception ex)
              {
                  Log.d("Error123",ex.getMessage());
              }finally {
                  Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                  startActivity(intent);
              }
          }
        };

        timer.start();

    }
}
