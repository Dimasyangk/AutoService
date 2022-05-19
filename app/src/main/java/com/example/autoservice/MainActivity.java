package com.example.autoservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonReg = (Button)findViewById(R.id.buttonReg);
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(MainActivity.this,registration_page.class);
                    startActivity(intent); finish();

                }catch (Exception e) {

                }
                }
        });

        Button button_forgot = (Button)findViewById(R.id.button_forgot);
        button_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(MainActivity.this,forgot_password.class);
                    startActivity(intent); finish();

                }catch (Exception e) {

                }

            }
        });



    }
}