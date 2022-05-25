package com.example.autoservice.mvvm.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoservice.R;
import com.example.autoservice.databinding.ChatPageBinding;
import com.example.autoservice.databinding.HomePageBinding;
import com.example.autoservice.mvvm.adapters.DisplayMessagesAdapter;
import com.example.autoservice.mvvm.adapters.DisplayRecordingsAdapter;
import com.example.autoservice.mvvm.model.Message;
import com.example.autoservice.mvvm.model.Recording;
import com.example.autoservice.mvvm.viewModels.ChatViewModel;
import com.example.autoservice.mvvm.viewModels.HomeViewModel;

import java.util.ArrayList;

public class ChatFragment extends Fragment {
    private ChatViewModel viewModel;
    private ChatPageBinding binding;
    private RecyclerView recyclerView;
    private DisplayMessagesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.chat_page, container, false);
        viewModel = new ViewModelProvider(this).get(ChatViewModel.class);
        binding = ChatPageBinding.bind(v);

        final Observer<ArrayList<Message>> nameObserver = new Observer<ArrayList<Message>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<Message> messages) {
                adapter = new DisplayMessagesAdapter(messages, requireContext(), viewModel);
                recyclerView.setAdapter(adapter);
            }
        };
        recyclerView = binding.messageRecyclerView;

        viewModel.getMessages(v).observe(getViewLifecycleOwner(), nameObserver);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);

        Button sendMessageButton = binding.chatSendButton;
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageText = binding.chatMessageText.getText().toString();

                viewModel.sendMessage(messageText);
                binding.chatMessageText.setText("");
                viewModel.getMessages(v).observe(getViewLifecycleOwner(), nameObserver);
            }
        });

        return v;
    }
}
