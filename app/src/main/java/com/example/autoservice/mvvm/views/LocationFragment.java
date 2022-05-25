package com.example.autoservice.mvvm.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.autoservice.R;
import com.example.autoservice.databinding.AutoserviceMapBinding;
import com.example.autoservice.mvvm.viewModels.LocationViewModel;

public class LocationFragment extends Fragment {
    private LocationViewModel viewModel;
    private AutoserviceMapBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.autoservice_map, container, false);
        viewModel = new ViewModelProvider(this).get(LocationViewModel.class);
        binding = AutoserviceMapBinding.bind(v);


        return v;
    }
}
