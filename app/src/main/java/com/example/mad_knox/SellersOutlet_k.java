package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SellersOutlet_k extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellers_outlet_k);
        EditText edit_product_name = findViewById(R.id.edit_product_name);
        EditText edit_product_category = findViewById(R.id.edit_product_category);
        EditText edit_product_price = findViewById(R.id.edit_product_price);
        EditText edit_product_quantity = findViewById(R.id.edit_product_quantity);
        EditText edit_product_description = findViewById(R.id.edit_product_description);
        EditText edit_product_image_link = findViewById(R.id.edit_product_image_link);
        Button btn = findViewById(R.id.btn_add_information);
        btn.setOnClickListener(v->
        {



        });
    }
}