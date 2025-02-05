package com.example.chatapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_screen);

        Button loginButton = findViewById(R.id.loginBtn);
        Button signupButton = findViewById(R.id.signupBtn);


        loginButton.setOnClickListener(v->{
            startActivity(new Intent(LoginScreen.this , ChatListScreen.class));
            finish();
        });
        signupButton.setOnClickListener(v->{
            startActivity(new Intent(LoginScreen.this , SignupScreen.class));
            finish();
        });


    }
}