package com.example.autoservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class registration_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_page);

        Button button_reg = (Button)findViewById(R.id.button_reg);
        button_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(registration_page.this,MainActivity.class);
                    startActivity(intent); finish();
                } catch (Exception e) {
                }
            }
        });

        };
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(registration_page.this,MainActivity.class);
            startActivity(intent); finish();
        } catch (Exception e) {
        }

    }
    }