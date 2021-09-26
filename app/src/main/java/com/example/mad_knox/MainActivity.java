package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

<<<<<<< HEAD
    private Button button;
=======
    Button buttonOpenSecond;
>>>>>>> 19161a621231824a7ed1f0d7bc812920d878b023

    @Override
    protected void onCreate(Bundle savedInstanceState) {

<<<<<<< HEAD
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login_intent = new Intent(MainActivity.this, Home_Page.class);
                startActivity(login_intent);
            }
        });
=======
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


>>>>>>> 19161a621231824a7ed1f0d7bc812920d878b023
    }


}