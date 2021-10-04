package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

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
        Outlet out_update = (Outlet)getIntent().getSerializableExtra("UPDATE");
        if(out_update !=null)
        {
            btn.setText("UPDATE");
            edit_outlet_name.setText(out_update.getName());
            edit_outlet_category.setText(out_update.getCategory());
            edit_outlet_description.setText(out_update.getDescription());
            edit_outlet_location.setText(out_update.getLocation());
        }

        btn.setOnClickListener(v->
        {
            Outlet out = new Outlet(edit_outlet_name.getText().toString(),edit_outlet_category.getText().toString(),edit_outlet_description.getText().toString(),edit_outlet_location.getText().toString());
            if(out_update==null)
            {
                dao.add(out).addOnSuccessListener(suc ->
                {
                    Toast.makeText(this, "Details entered successfully", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }

            else

            {

                HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put("name",edit_outlet_name.getText().toString());
                hashMap.put("category",edit_outlet_category.getText().toString());
                hashMap.put("description",edit_outlet_description.getText().toString());
                hashMap.put("location",edit_outlet_location.getText().toString());
                dao.update(out_update.getKey(), hashMap).addOnSuccessListener(suc->
                {
                    Toast.makeText(this, "Details updated successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }).addOnFailureListener(er->
                {
                    Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
                });

            }


            /*HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("name",edit_outlet_name.getText().toString());
            hashMap.put("category",edit_outlet_category.getText().toString());
            hashMap.put("description",edit_outlet_description.getText().toString());
            hashMap.put("location",edit_outlet_location.getText().toString());
            dao.update("-Ml5y-6LvwohoYCLvNwe",hashMap).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Details updated successfully", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->
            {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
            dao.remove("-Ml5y-6LvwohoYCLvNwe").addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Details deleted successfully", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->
            {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });*/




        });
    }
}