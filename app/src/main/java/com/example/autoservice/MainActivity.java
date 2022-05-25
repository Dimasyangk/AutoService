package com.example.autoservice;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.autoservice.databinding.ActivityMainBinding;
import com.example.autoservice.mvvm.views.ChatFragment;
import com.example.autoservice.mvvm.views.HomeFragment;
import com.example.autoservice.mvvm.views.LocationFragment;
import com.example.autoservice.mvvm.views.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();

        setContentView(view);
        replaceFragment(new HomeFragment());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home_page:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.profile_page:
                    replaceFragment(new ProfileFragment());
                    break;
                case R.id.location_page:
                    replaceFragment(new LocationFragment());
                    break;
                case R.id.chat_page:
                    replaceFragment(new ChatFragment());
                    break;
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(binding.fragmentHolder.getId(), fragment);
        fragmentTransaction.commit();
    }
}