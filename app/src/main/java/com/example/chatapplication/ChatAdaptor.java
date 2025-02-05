package com.example.chatapplication;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class ChatAdaptor extends RecyclerView.Adapter<ChatAdaptor.ViewHolder> {

    private  final List<String> chatList ;
    private  final Context context ;

    public ChatAdaptor(List<String> chatList , Context context)
    {
        this.chatList = chatList ;
        this.context = context ;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.chat_item,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder , int position)
    {
        holder.chatName.setText(chatList.get(position));
        holder.itemView.setOnClickListener(v->{
            Intent intent = new Intent(context , ChatScreen.class);
            intent.putExtra("name",chatList.get(position));
        });
    }



    @Override
    public int getItemCount()
    {
        return  chatList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView chatName;
        public  ViewHolder(View itemView)
        {
            super(itemView);
            chatName = itemView.findViewById(R.id.chatName);
        }

    }

}

