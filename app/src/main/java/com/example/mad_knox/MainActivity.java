package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mad_knox.fragments.Shop_Section;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Button shop_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        shop_btn = (Button) findViewById(R.id.shop_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login_intent = new Intent(MainActivity.this, Home_Page.class);
                startActivity(login_intent);
            }
        });

        shop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login_intent = new Intent(MainActivity.this, Shop_Section.class);
                startActivity(login_intent);
            }
        });
    }
}