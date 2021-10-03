package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateSellerOutlet_k extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_seller_outlet_k);
        final EditText edit_outlet_name = findViewById(R.id.edit_outlet_name);
        final EditText edit_outlet_category = findViewById(R.id.edit_outlet_category);
        final EditText edit_outlet_description = findViewById(R.id.edit_outlet_description);
        final EditText edit_outlet_location = findViewById(R.id.edit_outlet_location);
        Button btn = findViewById(R.id.btn_submit);
        DAOOutlet dao =new DAOOutlet();
        btn.setOnClickListener(v->
        {
            Outlet out = new Outlet(edit_outlet_name.getText().toString(),edit_outlet_category.getText().toString(),edit_outlet_description.getText().toString(),edit_outlet_location.getText().toString());
            dao.add(out).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Details entered successfully", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->
            {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });

        });
    }
}