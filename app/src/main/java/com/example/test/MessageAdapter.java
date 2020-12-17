package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


/**
 * Created by deathcode on 26/01/18.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.CustomViewHolder> {

    List<ResponsiveMessage> responseMessages;
    Context context;
    public void setData(List<ResponsiveMessage> list) {
        this.responseMessages = list;
        notifyDataSetChanged();
    }
    class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public CustomViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textMessage);
        }
    }

    public MessageAdapter(List<ResponsiveMessage> responseMessages, Context context) {
        this.responseMessages = responseMessages;
        this.context = context;
    }

    public int getItemViewType(int position) {
        if(this.getItemCount()==0){
            return R.layout.bot_bubble;
        }
        return R.layout.me_bubble;
    }
    public int getItemCount() {
        return  responseMessages.size();
    }
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.textView.setText(responseMessages.get(position).getText());
    }
}