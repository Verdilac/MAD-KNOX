package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackCRUD extends AppCompatActivity {

    EditText et_Feedname, et_Feedemail, et_Feedreview, et_quality, et_timelyResponse, et_satisfaction;
    Button btn_feed_cancel, btn_feed_submit;

    Feedback feedObj;

    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_crud);

        et_Feedname = findViewById(R.id.et_Feedname);
        et_Feedemail = findViewById(R.id.et_Feedemail);
        et_Feedreview = findViewById(R.id.et_Feedreview);
        et_quality = findViewById(R.id.et_quality);
        et_timelyResponse = findViewById(R.id.et_timelyResponse);
        et_satisfaction = findViewById(R.id.et_satisfaction);
        btn_feed_cancel = findViewById(R.id.btn_feed_cancel);
        btn_feed_submit = findViewById(R.id.btn_feed_submit);

        feedObj = new Feedback();

    }

    public void clearControls() {
        et_Feedname.setText("");
        et_Feedemail.setText("");
        et_Feedreview.setText("");
        et_quality.setText("");
        et_timelyResponse.setText("");
        et_satisfaction.setText("");
    }

    public void InsertFeed(View view){
        dbRef = FirebaseDatabase.getInstance().getReference().child("Feedback");
        if (TextUtils.isEmpty(et_Feedname.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter Your Name", Toast.LENGTH_SHORT).show();

        } else if (TextUtils.isEmpty(et_Feedemail.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter Your email", Toast.LENGTH_SHORT).show();

        } else if (TextUtils.isEmpty(et_Feedreview.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter Your Review", Toast.LENGTH_SHORT).show();

        } else if (TextUtils.isEmpty(et_quality.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Your Opinion", Toast.LENGTH_SHORT).show();

        } else if (TextUtils.isEmpty(et_timelyResponse.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Your Opinion", Toast.LENGTH_SHORT).show();

        } else if (TextUtils.isEmpty(et_satisfaction.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Your Opinion", Toast.LENGTH_SHORT).show();

        }else {
            //take inputs from the user and assigning them to the instance of the Feedback
            feedObj.setName(et_Feedname.getText().toString().trim());
            feedObj.setEmail(et_Feedemail.getText().toString().trim());
            feedObj.setReview(et_Feedreview.getText().toString().trim());
            feedObj.setQuality(et_quality.getText().toString().trim());
            feedObj.setTimelyResponse(et_timelyResponse.getText().toString().trim());
            feedObj.setoSatisfaction(et_satisfaction.getText().toString().trim());

            dbRef.push().setValue(feedObj);

            Toast.makeText(getApplicationContext(), "Feedback Received Successfully", Toast.LENGTH_SHORT).show();
            clearControls();

            Intent intent = new Intent(this, FeedbackConfirm.class);
            startActivity(intent);
        }

    }





}