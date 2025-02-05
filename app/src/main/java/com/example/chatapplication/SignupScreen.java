package com.example.chatapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SignupScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_screen);

        Button registerButton = findViewById(R.id.registerBtn);


        registerButton.setOnClickListener(v->{
            startActivity(new Intent(this, ChatListScreen.class));
            finish();
        });

    }
}