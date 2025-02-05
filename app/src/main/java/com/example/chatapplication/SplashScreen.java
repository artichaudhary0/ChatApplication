package com.example.chatapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {


    /*
    * Splash screen
    * login
    * signup
    * chat list
    * chat screen
    * status
    * Contact Screen
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(()->{
            startActivity(new Intent(this, LoginScreen.class));
            finish();
        },2000);

    }
}