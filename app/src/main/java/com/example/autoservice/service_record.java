package com.example.autoservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class service_record extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_record);

        Button add_recordButton = (Button)findViewById(R.id.add_recordButton);
        add_recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(service_record.this,add_record.class);
                    startActivity(intent); finish();

                }catch (Exception e) {

                }
            }
        });
    }
}