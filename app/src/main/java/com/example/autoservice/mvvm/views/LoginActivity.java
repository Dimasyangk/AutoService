package com.example.autoservice.mvvm.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.autoservice.R;
import com.example.autoservice.MainActivity;
import com.example.autoservice.service_record;
import com.example.autoservice.mvvm.viewModels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    EditText emailAccess;
    EditText passwordAccess;
    Button buttonAuthorize;

    LoginViewModel loginVM;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailAccess = (EditText) findViewById(R.id.email_enter);
        passwordAccess = (EditText) findViewById(R.id.password_enter);
        buttonAuthorize = (Button) findViewById(R.id.button_main);

        loginVM = new ViewModelProvider(this).get(LoginViewModel.class);

        loginVM.getEmail().observe(this, email -> {
            emailAccess.setText(email);
        });

        loginVM.getPassword().observe(this, password -> {
            passwordAccess.setText(password);
        });

        loginVM.getAccess().observe(this, access -> {
            if (access) {
                startActivity(new Intent(this, service_record.class));
                Toast.makeText(this, "Welcome," + loginVM.getUserNickName(), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, " This user didn't exists!", Toast.LENGTH_LONG).show();
            }
        });

        buttonAuthorize.setOnClickListener(view -> {
            String email = emailAccess.getText().toString();
            String password = passwordAccess.getText().toString();
            loginVM.authorize(email,password);
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        emailAccess.setText("");
        passwordAccess.setText("");
    }
}
