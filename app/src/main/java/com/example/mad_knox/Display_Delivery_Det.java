package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Display_Delivery_Det extends AppCompatActivity {

    EditText et_name, et_phone, et_email, et_ShippingAdd, et_city;
    Button btn_random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_delivery_det);


        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        et_email = findViewById(R.id.et_email);
        et_ShippingAdd = findViewById(R.id.et_ShippingAdd);
        et_city = findViewById(R.id.et_city);



        Intent intent = getIntent();

        String name = intent.getStringExtra("name1");
        String phone = intent.getStringExtra("phone1");
        String email = intent.getStringExtra("email1");
        String ShippingAdd = intent.getStringExtra("ShippingAdd1");
        String city = intent.getStringExtra("city1");

        // set those values in the edit text
        et_name.setText(name);
        et_phone.setText(phone);
        et_email.setText(email);
        et_ShippingAdd.setText(ShippingAdd);
        et_city.setText(city);
    }

    // Intent for back to main page in Delivery
    public void BacktoDel_Crud(View view){
        Intent intent = new Intent(this, Delivery_Crud_Op.class);
        startActivity(intent);
    }
}