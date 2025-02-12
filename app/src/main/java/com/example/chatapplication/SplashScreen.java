package com.example.chatapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

        SharedPreferences preferences = getSharedPreferences("ChatAppPrefs" , Context.MODE_PRIVATE);

        boolean isLoggedIn = preferences.getBoolean("isLoggedIn",false);

        new Handler().postDelayed(() -> {

            if(isLoggedIn)
            {
                Intent  intent = new Intent(SplashScreen.this, ChatListScreen.class);
                startActivity(intent);
            }else{
                startActivity(new Intent(this, SignupScreen.class));
            }
            finish();
        },2000);

    }
}