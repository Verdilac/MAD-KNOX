package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.HashMap;

public class Product_Details_Page extends AppCompatActivity {

    ImageView back_arrow_btn;

    EditText p_name, p_description, p_price, p_location, p_img_url;
    Button add_product_btn, open_recycler_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details_page);

        back_arrow_btn = (ImageView) findViewById(R.id.back_arrow_btn);

//        final EditText p_name = findViewById(R.id.p_name);
//        final EditText p_description = findViewById(R.id.p_description);
//        final EditText p_price = findViewById(R.id.p_price);
//        final EditText p_location = findViewById(R.id.p_location);
//        final EditText p_img_url = findViewById(R.id.p_img_url);


        p_name = (EditText) findViewById(R.id.p_name);
        p_description = (EditText) findViewById(R.id.p_description);
        p_price = (EditText) findViewById(R.id.p_price);
        p_location = (EditText) findViewById(R.id.p_location);
        p_img_url = (EditText) findViewById(R.id.p_img_url);

        add_product_btn = (Button) findViewById(R.id.add_product_btn);
        open_recycler_view = (Button) findViewById(R.id.open_recycler_view);


        // DOAProduct Object
        DAOProduct dao = new DAOProduct();


        // Open Recycler View Btn
        open_recycler_view.setOnClickListener(v -> {
            Intent intent = new Intent(Product_Details_Page.this, RVActivity_P.class);
            startActivity(intent);
        });


        // Get object from the Product that we pass from RVAdapter
        ProductData prod_edit = (ProductData) getIntent().getSerializableExtra("EDIT");

        // if not null pass the value to update
        if (prod_edit != null){

            add_product_btn.setText("Update Product");

            p_name.setText(prod_edit.getProduct_Name());
            p_description.setText(prod_edit.getProduct_Desc());
            p_price.setText(String.valueOf(prod_edit.getProduct_Price()));
            p_location.setText(prod_edit.getProduct_Location());
            p_img_url.setText(prod_edit.getProduct_Img());

            // Hide Recycler View Btn
            open_recycler_view.setVisibility(View.GONE);

        }
        else{  // if null its the insert function

            add_product_btn.setText("Add Product");
            open_recycler_view.setVisibility(View.VISIBLE);
        }



        // Add Product Btn
        add_product_btn.setOnClickListener(v -> {

            // Preparing prod object
            ProductData prod = new ProductData(p_name.getText().toString(),p_description.getText().toString(),Integer.parseInt(p_price.getText().toString()),p_location.getText().toString(),p_img_url.getText().toString());

            if (prod_edit == null){

                // INSERT
                dao.add(prod).addOnSuccessListener(suc -> {
                    Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    clearFormFields();
                }).addOnFailureListener(er -> {
                    Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();    // Toasts the error
                });
            }

            else{

                // UPDATE
                HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put("product_Name",p_name.getText().toString());
                hashMap.put("product_Desc",p_description.getText().toString());
                hashMap.put("product_Price",Integer.parseInt(p_price.getText().toString()));
                hashMap.put("product_Location",p_location.getText().toString());
                hashMap.put("product_Img",p_img_url.getText().toString());

                dao.update(prod_edit.getKey(),hashMap).addOnSuccessListener(suc -> {
                    Toast.makeText(this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                    clearFormFields();
                    finish();

                }).addOnFailureListener(er -> {

                    Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();    // Toasts the error
                });
            }

        });


        // Back Arrow Activity
        back_arrow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_to_home_intent = new Intent(Product_Details_Page.this, Home_Page.class);
                startActivity(back_to_home_intent);
            }
        });




    }

    // Setting all EditText values to empty once a button is clicked
    // Clearing the input fields
    private void clearFormFields(){
        p_name.setText("");
        p_description.setText("");
        p_price.setText("");
        p_location.setText("");
        p_img_url.setText("");
    }



}