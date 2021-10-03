package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_outlet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //INITILIZIATION

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_outlet = (Button) findViewById(R.id.btn_outlet);
        btn_outlet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,CreateSellerOutlet_k.class);
                startActivity(i);
            }
        });
    }
}