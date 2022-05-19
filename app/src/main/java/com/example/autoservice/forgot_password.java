package com.example.autoservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class forgot_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);


        Button buttonRecover = (Button)findViewById(R.id.buttonRecover);
        buttonRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) findViewById(R.id.ButtonRec);
                textView.setText("Код был успешно отправлен на вашу эл. почту");
            }
        });

        Button ContinueButton = (Button)findViewById(R.id.ContinueButton);
        ContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(forgot_password.this,MainActivity.class);
                    startActivity(intent); finish();

                }catch (Exception e) {

                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(forgot_password.this,MainActivity.class);
            startActivity(intent); finish();
        } catch (Exception e) {
        }

    }
}