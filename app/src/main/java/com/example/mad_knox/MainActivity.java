package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mad_knox.dispute.DisputeHandle;
import com.example.mad_knox.dispute.RVDispute;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {



    Button submit,redirect,recy;
    //payment merged with productlisting

//paydelprod


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //INITILIZIATION
        //THis is the integration branch



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);










        recy = findViewById(R.id.recy_view);

        recy.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,Rvpayments.class);
            startActivity(intent);
        });

        Button btn_dispute = findViewById(R.id.btn_dispute);

        btn_dispute.setOnClickListener(v->{
            Intent intent = new Intent(this, DisputeHandle.class);
            startActivity(intent);
        });


        Button btn_disputelist = findViewById(R.id.btn_disputelist);

        btn_disputelist.setOnClickListener(v->{
            Intent intent = new Intent(this, RVDispute.class);
            startActivity(intent);

        });




        Button btn_pinto = findViewById(R.id.btn_pinto);
        btn_pinto.setOnClickListener(v->{
            Intent intent = new Intent(this,Home_Page.class);
            startActivity(intent);
        });

        Button btn_ushan = findViewById(R.id.btn_ushan);
        btn_ushan.setOnClickListener(v->{
            Intent intent = new Intent(this,Delivery_Main.class);
            startActivity(intent);
        });
        Button btn_feedback = findViewById(R.id.btn_feedback);
        btn_feedback.setOnClickListener(v->{
            Intent intent = new Intent(this,FeedbackCRUD.class);
            startActivity(intent);
        });





    }



    public void redirection (View view){
        Intent intent = new Intent(getApplicationContext(),Cardpayment.class);
        startActivity(intent);
    }

    public void lunchUpdate(View view){
        Intent intent = new Intent(getApplicationContext(),CardUpdate.class);
        startActivity(intent);

    }


}