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
import com.example.autoservice.mvvm.viewModels.ChatViewModel;

import java.util.ArrayList;

public class DisplayMessagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ChatViewModel viewModel;
    private ArrayList<Message> messagesList;
    Context context;

    public DisplayMessagesAdapter(ArrayList<Message> data, Context context, ChatViewModel viewModel) {
        this.messagesList = data;
        this.context = context;
        this.viewModel = viewModel;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder vh;
        View itemLayoutView;

        switch (viewType)
        {
            case 0:
                itemLayoutView = inflater.inflate(R.layout.author_message_fragment, parent, false);
                vh = new AuthorMessageViewHolder(itemLayoutView);
                break;
            case 1:
                itemLayoutView = inflater.inflate(R.layout.receiver_message_fragment, parent, false);
                vh = new ReceiverMessageViewHolder(itemLayoutView);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (this.getItemViewType(position))
        {
            case 0:
                AuthorMessageViewHolder authorMessageViewHolder = (AuthorMessageViewHolder) holder;
                ((AuthorMessageViewHolder) holder).text.setText(messagesList.get(position).getTextMessage());
                break;
            case 1:
                ReceiverMessageViewHolder receiverMessageViewHolder = (ReceiverMessageViewHolder) holder;
                ((ReceiverMessageViewHolder) holder).text.setText(messagesList.get(position).getTextMessage());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (messagesList.get(position).getAuthorId() == 1) {
            return 0;
        }
        else if (messagesList.get(position).getReceiverId() == 1) {
            return 1;
        }
        else {
            return -1;
        }
    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }

    public static class AuthorMessageViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public AuthorMessageViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.author_text);
        }
    }

    public static class ReceiverMessageViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public ReceiverMessageViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.receiver_text);
        }
    }
}