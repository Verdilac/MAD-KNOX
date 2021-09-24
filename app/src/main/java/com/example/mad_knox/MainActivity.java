package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonOpenSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //INITILIZIATION
//        lathinduadded

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonOpenSecond = (Button) findViewById(R.id.buttonOpenSecond);
        buttonOpenSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PaymentActivity.class);
                startActivity(intent);
            }
        });


    }


}