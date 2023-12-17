package com.aristoncaragay.onboardingsplashscreen;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isNetworkAvailable()) {
                    startActivity(new Intent(SplashActivity.this, SliderScreen.class));
                    finish();
                } else {
                    Toast.makeText(SplashActivity.this, "No internet connection", Toast.LENGTH_SHORT).show();
                    // You can choose to finish the activity or take other actions based on your requirements
                }
            }
        }, 5000);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
