package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

Button btn_feed_start;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //INITILIZIATION

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_feed_start = findViewById(R.id.btn_feed_start);
    }

    public void moveToFirebaseCrud(View view){
        Intent intent = new Intent(this, FeedbackCRUD.class);
        startActivity(intent);
    }
}