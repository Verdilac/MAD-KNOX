package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FeedbackConfirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_confirm);
    }

    public void backToFeedback(View view){
        Intent intent = new Intent(this, FeedbackCRUD.class);
        startActivity(intent);
    }
}