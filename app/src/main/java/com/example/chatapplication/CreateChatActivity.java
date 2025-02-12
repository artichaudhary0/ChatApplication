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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreateChatActivity extends AppCompatActivity {


    private EditText chatNameInput ;
    private Button saveChatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_chat);

        chatNameInput = findViewById(R.id.chatNameInput);
        saveChatBtn = findViewById(R.id.saveChat);

        saveChatBtn.setOnClickListener(v->{
            String newChat = chatNameInput.getText().toString().trim();

            if(!newChat.isEmpty())
            {
                SharedPreferences prefs = getSharedPreferences("ChatAppPrefs", Context.MODE_PRIVATE);
                String existingChat = prefs.getString("chats","");
                if(!existingChat.isEmpty())
                {
                    existingChat += "," + newChat;
                }else{
                    existingChat = newChat;
                }

                prefs.edit().putString("chats",existingChat).apply();

                Toast.makeText(this, "Chat Added!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CreateChatActivity.this , ChatListScreen.class));
                finish();

            }else{
                Toast.makeText(this, "Enter a valid name",Toast.LENGTH_SHORT).show();
            }



        });



    }
}