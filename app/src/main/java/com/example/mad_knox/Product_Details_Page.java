package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Product_Details_Page extends AppCompatActivity {

    ImageView back_arrow_btn, uploaded_product_img;

    EditText p_name, p_description, p_price, p_location;
    Button product_img_upload_btn, add_product_btn;

    // Instance of Products_Details class
    Products_Details productObj;

    // Instance of DB
    DatabaseReference dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details_page);

        back_arrow_btn = (ImageView) findViewById(R.id.back_arrow_btn);
        uploaded_product_img = (ImageView) findViewById(R.id.uploaded_product_img);

        p_name = (EditText) findViewById(R.id.p_name);
        p_description = (EditText) findViewById(R.id.p_description);
        p_price = (EditText) findViewById(R.id.p_price);
        p_location = (EditText) findViewById(R.id.p_location);

        product_img_upload_btn = (Button) findViewById(R.id.product_img_upload_btn);
        add_product_btn = (Button) findViewById(R.id.add_product_btn);

        productObj = new Products_Details();




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
    }


    // 1) Crud Functionalities - Create
    public void CreateProduct(View view){

        dbRef = FirebaseDatabase.getInstance().getReference().child("Products"); // Products is the table name

        try{
            // Form Empty Validations
            if(TextUtils.isEmpty(p_name.getText().toString())){
                Toast.makeText(getApplicationContext(), "Please enter the Product Name", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(p_description.getText().toString())){
                Toast.makeText(getApplicationContext(), "Please enter the Product Description", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(p_price.getText().toString())){
                Toast.makeText(getApplicationContext(), "Please enter the Product Price", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(p_location.getText().toString())){
                Toast.makeText(getApplicationContext(), "Please enter the Product Location", Toast.LENGTH_SHORT).show();
            }else {

                // Setting the values to product object using setters
                productObj.setProduct_Name(p_name.getText().toString().trim());
                productObj.setProduct_Desc(p_description.getText().toString().trim());
                productObj.setProduct_Price(Integer.parseInt(p_price.getText().toString().trim()));
                productObj.setProduct_Location(p_location.getText().toString().trim());

                // Push the data into firebase Products db
                dbRef.push().setValue(productObj);

                // Providing our own id for each row in DB
                // dbRef.child("product1").setValue(productObj);

                // Successful data insertion
                Toast.makeText(getApplicationContext(), "Data inserted successfully", Toast.LENGTH_SHORT).show();
                clearFormFields();

            }
        }catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(), "Invalid Product Price", Toast.LENGTH_SHORT).show();
        }

    }



}