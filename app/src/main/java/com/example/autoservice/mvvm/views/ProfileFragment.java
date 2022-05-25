package com.example.autoservice.mvvm.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoservice.R;
import com.example.autoservice.databinding.AutoserviceMapBinding;
import com.example.autoservice.databinding.ProfilePageBinding;
import com.example.autoservice.mvvm.adapters.DisplayCarWorkAdapter;
import com.example.autoservice.mvvm.adapters.DisplayCarsAdapter;
import com.example.autoservice.mvvm.adapters.DisplayRecordingsAdapter;
import com.example.autoservice.mvvm.model.Recording;
import com.example.autoservice.mvvm.model.User;
import com.example.autoservice.mvvm.viewModels.LocationViewModel;
import com.example.autoservice.mvvm.viewModels.ProfileViewModel;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    private ProfileViewModel viewModel;
    private ProfilePageBinding binding;
    private RecyclerView recyclerView;
    private DisplayCarWorkAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile_page, container, false);
        viewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        binding = ProfilePageBinding.bind(v);

        User user = viewModel.getCurrentUser().getValue();
        binding.profileName.setText(user.getName());
        binding.profileCity.setText(user.getCity());
        binding.profileTel.setText(user.getTel());

        Button changeDataButton = binding.changeDataButton;
        changeDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = binding.profileName.getText().toString();
                String newCity = binding.profileCity.getText().toString();
                String newTel = binding.profileTel.getText().toString();

                viewModel.getCurrentUser().getValue().setName(newName);
                viewModel.getCurrentUser().getValue().setCity(newCity);
                viewModel.getCurrentUser().getValue().setTel(newTel);
            }
        });

        final Observer<ArrayList<Recording>> nameObserver = new Observer<ArrayList<Recording>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<Recording> recordings) {
                adapter = new DisplayCarWorkAdapter(recordings, requireContext(), viewModel);
                recyclerView.setAdapter(adapter);
            }
        };
        recyclerView = binding.profileRecyclerView;

        viewModel.getDoneRecordings(v).observe(getViewLifecycleOwner(), nameObserver);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);

        return v;
    }
}
