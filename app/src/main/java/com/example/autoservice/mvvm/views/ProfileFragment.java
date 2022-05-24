package com.example.autoservice.mvvm.views;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoservice.databinding.ProfilePageBinding;
import com.example.autoservice.mvvm.adapters.DisplayCarsAdapter;
import com.example.autoservice.mvvm.viewModels.ProfileViewModel;

public class ProfileFragment extends Fragment {
    private ProfileViewModel viewModel;
    private ProfilePageBinding binding;
    private RecyclerView recyclerView;
    private DisplayCarsAdapter adapter;
}
