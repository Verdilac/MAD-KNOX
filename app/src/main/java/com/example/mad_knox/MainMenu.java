package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.mad_knox.dispute.DisputeHandle;
import com.example.mad_knox.dispute.RVDispute;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button login_menu_btn,home_menu_btn,payment_menu_btn,feedback_menu_btn,seller_o_menu_btn,delivery_menu_btn,dispute_btn,disputelist_btn;


        login_menu_btn = findViewById(R.id.login_menu_btn);
        home_menu_btn = findViewById(R.id.home_menu_btn);
        payment_menu_btn = findViewById(R.id.payment_menu_btn);
        feedback_menu_btn = findViewById(R.id.feedback_menu_btn);
        seller_o_menu_btn = findViewById(R.id.seller_o_menu_btn);
        delivery_menu_btn = findViewById(R.id.delivery_menu_btn);
        dispute_btn = findViewById(R.id.dispute_btn);
        disputelist_btn = findViewById(R.id.disputelist_btn);



        login_menu_btn.setOnClickListener(v->{
            Intent intent = new Intent(this,Login_Page.class);
            startActivity(intent);
        });

        home_menu_btn.setOnClickListener(v->{
            Intent intent = new Intent(this,Home_Page.class);
            startActivity(intent);
        });

        payment_menu_btn.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(),Cardpayment.class);
            startActivity(intent);
        });

        feedback_menu_btn.setOnClickListener(v->{
            Intent intent = new Intent(this,FeedbackCRUD.class);
            startActivity(intent);
        });
        delivery_menu_btn.setOnClickListener(v->{
            Intent intent = new Intent(this,Delivery_Main.class);
            startActivity(intent);
        });
//        seller_o_menu_btn.setOnClickListener(v->{
//            Intent intent = new Intent(this,Delivery_Main.class);
//            startActivity(intent);
//        });

        dispute_btn.setOnClickListener(v->{
            Intent intent = new Intent(this, DisputeHandle.class);
            startActivity(intent);
        });

        disputelist_btn.setOnClickListener(v->{
            Intent intent = new Intent(this, RVDispute.class);
            startActivity(intent);
        });




    }
}