package com.example.autoservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class add_record extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_record);

        Button buttonContinue = (Button)findViewById(R.id.buttonContinue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(add_record.this,service_record.class);
                    startActivity(intent); finish();

                }catch (Exception e) {

                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(add_record.this,service_record.class);
            startActivity(intent); finish();
        } catch (Exception e) {
        }

    }
}
