package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Product_Details_Page extends AppCompatActivity {

    private ImageView back_arrow_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details_page);

        back_arrow_btn = (ImageView) findViewById(R.id.back_arrow_btn);

        // Back Arrow
        back_arrow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_to_home_intent = new Intent(Product_Details_Page.this, Home_Page.class);
                startActivity(back_to_home_intent);
            }
        });
    }
}