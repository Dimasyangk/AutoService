package com.example.autoservice.mvvm.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autoservice.R;
import com.example.autoservice.databinding.AddRecordBinding;
import com.example.autoservice.databinding.HomePageBinding;
import com.example.autoservice.mvvm.model.User;
import com.example.autoservice.mvvm.viewModels.CreateRecordingViewModel;
import com.example.autoservice.mvvm.viewModels.HomeViewModel;

public class CreateRecordingFragment extends Fragment {
    private CreateRecordingViewModel viewModel;
    private AddRecordBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_record, container, false);
        viewModel = new ViewModelProvider(this).get(CreateRecordingViewModel.class);
        binding = AddRecordBinding.bind(v);

        User user = viewModel.getCurrentUser();
        if (!user.getCity().equals("N/A")) {
            binding.addRecordingCity.setText(user.getCity());
        }
        if (!user.getName().equals("N/A")) {
            binding.addRecordingName.setText(user.getName());
        }
        if (!user.getTel().equals("N/A")) {
            binding.addRecordingTelephone.setText(user.getTel());
        }


        Button submitButton = binding.addRecordingButtonSubmit;
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = binding.addRecordingCity.getText().toString();
                String name = binding.addRecordingName.getText().toString();
                String tel = binding.addRecordingTelephone.getText().toString();
                String carName = binding.addRecordingCarName.getText().toString();
                String carYear = binding.addRecordingCarYear.getText().toString();
                String carNum = binding.addRecordingCarNum.getText().toString();
                String reason = binding.addRecordingReason.getText().toString();
                viewModel.makeRecording(city, name, tel, carName, carYear, carNum, reason);

                Fragment someFragment = new HomeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentHolder, someFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return v;
    }
}
