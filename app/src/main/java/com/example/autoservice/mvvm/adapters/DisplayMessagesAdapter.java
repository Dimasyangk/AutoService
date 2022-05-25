package com.example.autoservice.mvvm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoservice.R;
import com.example.autoservice.mvvm.model.Message;
import com.example.autoservice.mvvm.model.Recording;
import com.example.autoservice.mvvm.viewModels.ChatViewModel;
import com.example.autoservice.mvvm.viewModels.HomeViewModel;

import java.util.ArrayList;

public class DisplayMessagesAdapter extends RecyclerView.Adapter<DisplayMessagesAdapter.DisplayMessagesViewHolder> {
    private ChatViewModel viewModel;
    private ArrayList<Message> messagesList;
    Context context;

    public DisplayMessagesAdapter(ArrayList<Message> data, Context context, ChatViewModel viewModel) {
        this.messagesList = data;
        this.context = context;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public DisplayMessagesAdapter.DisplayMessagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.author_message_fragment, parent, false);

        return new DisplayMessagesAdapter.DisplayMessagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DisplayMessagesAdapter.DisplayMessagesViewHolder holder, int position) {
        final Message tempMessage = messagesList.get(position);

        holder.text.setText(tempMessage.getTextMessage());
    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }


    public static class DisplayMessagesViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        public DisplayMessagesViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.author_text);
        }
    }
}
