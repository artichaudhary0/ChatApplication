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

public class LoginScreen extends AppCompatActivity {

    private EditText email , password;
    private Button loginBtn , signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_screen);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        signupBtn = findViewById(R.id.signupButton);


        loginBtn.setOnClickListener(v->{
            String userName = email.getText().toString().trim();
            String userPassword = password.getText().toString().trim();

            SharedPreferences prefs = getSharedPreferences("ChatAppPrefs",Context.MODE_PRIVATE);
            String savedPassword = prefs.getString(userName,"");

            if(savedPassword.equals(userPassword))
            {
                prefs.edit().putBoolean("isLoggedIn",true).apply();
                prefs.edit().putString("loggedUser",userName).apply();
                startActivity(new Intent(LoginScreen.this,ChatListScreen.class));
                finish();
            }else {
                Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
            }
        });
        signupBtn.setOnClickListener(v->{
            startActivity(new Intent(LoginScreen.this , SignupScreen.class));
            finish();
        });


    }
}