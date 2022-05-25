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
import com.example.autoservice.databinding.HomePageBinding;
import com.example.autoservice.mvvm.adapters.DisplayRecordingsAdapter;
import com.example.autoservice.mvvm.model.Recording;
import com.example.autoservice.mvvm.viewModels.HomeViewModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private HomeViewModel viewModel;
    private HomePageBinding binding;
    private RecyclerView recyclerView;
    private DisplayRecordingsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_page, container, false);
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = HomePageBinding.bind(v);

        final Observer<ArrayList<Recording>> nameObserver = new Observer<ArrayList<Recording>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<Recording> recordings) {
                adapter = new DisplayRecordingsAdapter(recordings, requireContext(), viewModel);
                recyclerView.setAdapter(adapter);
            }
        };
        recyclerView = binding.recordingsRecyclerView;

        viewModel.getRecordings(v).observe(getViewLifecycleOwner(), nameObserver);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);

        Button makeRecordingButton = binding.addRecordButton;

        makeRecordingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment someFragment = new CreateRecordingFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentHolder, someFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return v;
    }
}
