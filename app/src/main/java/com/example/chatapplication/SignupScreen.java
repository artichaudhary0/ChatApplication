package com.example.chatapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SignupScreen extends AppCompatActivity {
    private Button registerButton, loginButton;
    private EditText etUserName , etUserPassword, etConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_screen);


        etUserName = findViewById(R.id.email);
        etUserPassword = findViewById(R.id.password);
        etConfirmPassword = findViewById(R.id.cPassword);


        loginButton = findViewById(R.id.signupButton);
        registerButton = findViewById(R.id.registerButton);

        loginButton.setOnClickListener(v->{
            startActivity(new Intent(this, LoginScreen.class));
            finish();
        });

        registerButton.setOnClickListener(v->{

            String username = etUserName.getText().toString().trim();
            String password = etUserPassword.getText().toString().trim();
            String cPassword = etConfirmPassword.getText().toString().trim();

            SharedPreferences prefs = getSharedPreferences("ChatAppPrefs", Context.MODE_PRIVATE);
            prefs.edit().putString(username,password).apply();

            Toast.makeText(this,"SignUp successfully",Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, LoginScreen.class));
            finish();
        });

    }
}