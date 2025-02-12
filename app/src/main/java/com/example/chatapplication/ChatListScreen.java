package com.example.chatapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChatListScreen extends AppCompatActivity {
    RecyclerView recyclerView ;
    List<String> chats;
    ChatAdaptor adapter;
//


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat_list);

       recyclerView = findViewById(R.id.recyclerView);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fabAddChat = findViewById(R.id.fabAddChat);

        fabAddChat.setOnClickListener(v->startActivity(new Intent(ChatListScreen.this,CreateChatActivity.class)));

        loadChats();
    }
    private  void loadChats(){
        SharedPreferences prefs = getSharedPreferences("ChatAppPrefs", Context.MODE_PRIVATE);
        String chatData = prefs.getString("chats","");

        if(!chatData.isEmpty())
        {
            chats = new ArrayList<>(Arrays.asList(chatData.split(",")));
        }else {
            chats = new ArrayList<>();
        }

        adapter = new ChatAdaptor(chats,this);
        recyclerView.setAdapter(adapter);

    }
}