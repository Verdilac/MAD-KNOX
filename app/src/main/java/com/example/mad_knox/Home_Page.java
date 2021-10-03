package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Home_Page extends AppCompatActivity {

    private ImageView hamburger_menu, profile_btn, cart_btn;

    private CardView card1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        profile_btn = (ImageView) findViewById(R.id.profile_btn);
        card1 = (CardView) findViewById(R.id.card1);

        // Profile Btn
        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login_page_intent = new Intent(Home_Page.this, Login_Page.class);
                startActivity(login_page_intent);
            }
        });

        // Add Product Details form trigger
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product_details_form_intent = new Intent(Home_Page.this, Product_Details_Page.class);
                startActivity(product_details_form_intent);
            }
        });

    }
}

// Card View to New Activity : https://www.youtube.com/watch?v=DocKN8yX9qc