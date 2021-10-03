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

import java.util.HashMap;

public class Product_Details_Page extends AppCompatActivity {

    ImageView back_arrow_btn;

    EditText p_name, p_description, p_price, p_location, p_img_url;
    Button add_product_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details_page);

        back_arrow_btn = (ImageView) findViewById(R.id.back_arrow_btn);

        p_name = (EditText) findViewById(R.id.p_name);
        p_description = (EditText) findViewById(R.id.p_description);
        p_price = (EditText) findViewById(R.id.p_price);
        p_location = (EditText) findViewById(R.id.p_location);
        p_img_url = (EditText) findViewById(R.id.p_img_url);

        add_product_btn = (Button) findViewById(R.id.add_product_btn);

        // DOAProduct Object
        DAOProduct dao = new DAOProduct();


        // Add Product Btn
        add_product_btn.setOnClickListener(v -> {

//            // Preparing prod object
//            ProductData prod = new ProductData(p_name.getText().toString(),p_description.getText().toString(),Integer.parseInt(p_price.getText().toString()),p_location.getText().toString(),p_img_url.getText().toString());
//
//            // Callback Listener
//            dao.add(prod).addOnSuccessListener(suc -> {
//                Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
//                clearFormFields();
//            }).addOnFailureListener(er -> {
//                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();    // Toasts the error
//            });


//            // Update
//            HashMap<String,Object> hashMap = new HashMap<>();
//            hashMap.put("Product_Name",p_name.getText().toString());
//            hashMap.put("Product_Desc",p_description.getText().toString());
//            hashMap.put("Product_Price",Integer.parseInt(p_price.getText().toString()));
//            hashMap.put("Product_Location",p_location.getText().toString());
//            hashMap.put("Product_Img",p_img_url.getText().toString());
//
//            dao.update("-Ml2vJnypYeLr62tDJ46",hashMap).addOnSuccessListener(suc -> {
//                Toast.makeText(this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
//                clearFormFields();
//            }).addOnFailureListener(er -> {
//                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();    // Toasts the error
//            });


            // Delete
            dao.remove("-Ml2vJnypYeLr62tDJ46").addOnSuccessListener(suc -> {
                Toast.makeText(this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                clearFormFields();
            }).addOnFailureListener(er -> {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();    // Toasts the error
            });


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
//
//
//    // 1) Crud Functionalities - Create
//    public void CreateProduct(View view){
//
//        dbRef = FirebaseDatabase.getInstance().getReference().child("Products"); // Products is the table name
//
//        try{
//            // Form Empty Validations
//            if(TextUtils.isEmpty(p_name.getText().toString())){
//                Toast.makeText(getApplicationContext(), "Please enter the Product Name", Toast.LENGTH_SHORT).show();
//            }else if(TextUtils.isEmpty(p_description.getText().toString())){
//                Toast.makeText(getApplicationContext(), "Please enter the Product Description", Toast.LENGTH_SHORT).show();
//            }else if(TextUtils.isEmpty(p_price.getText().toString())){
//                Toast.makeText(getApplicationContext(), "Please enter the Product Price", Toast.LENGTH_SHORT).show();
//            }else if(TextUtils.isEmpty(p_location.getText().toString())){
//                Toast.makeText(getApplicationContext(), "Please enter the Product Location", Toast.LENGTH_SHORT).show();
//            }else {
//
//                // Setting the values to product object using setters
//                productObj.setProduct_Name(p_name.getText().toString().trim());
//                productObj.setProduct_Desc(p_description.getText().toString().trim());
//                productObj.setProduct_Price(Integer.parseInt(p_price.getText().toString().trim()));
//                productObj.setProduct_Location(p_location.getText().toString().trim());
//
//                // Push the data into firebase Products db
//                dbRef.push().setValue(productObj);
//
//                // Providing our own id for each row in DB
//                // dbRef.child("product1").setValue(productObj);
//
//                // Successful data insertion
//                Toast.makeText(getApplicationContext(), "Data inserted successfully", Toast.LENGTH_SHORT).show();
//                clearFormFields();
//
//            }
//        }catch (NumberFormatException e){
//            Toast.makeText(getApplicationContext(), "Invalid Product Price", Toast.LENGTH_SHORT).show();
//        }
//
//    }



}