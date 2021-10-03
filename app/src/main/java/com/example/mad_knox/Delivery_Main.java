package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Delivery_Main extends AppCompatActivity {

    EditText et_name, et_phone, et_email, et_ShippingAdd, et_city;
    Button btn_Shipping_Cancel, btn_Shipping_Save;
    Delivery delObj;
    DatabaseReference dbRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //INITILIZIATION

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_main);

        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        et_email = findViewById(R.id.et_email);
        et_ShippingAdd = findViewById(R.id.et_ShippingAdd);
        et_city = findViewById(R.id.et_city);

        btn_Shipping_Save = findViewById(R.id.btn_Shipping_Save);
        btn_Shipping_Cancel = findViewById(R.id.btn_Shipping_Cancel);

        delObj = new Delivery();
    }

    // clearControl method
    public void ClearControls(){
        et_name.setText("");
        et_phone.setText("");
        et_email.setText("");
        et_ShippingAdd.setText("");
        et_city.setText("");
    }

    public void openDeliveryCrud(View view){

        // insert all the entered data into the database
        dbRef = FirebaseDatabase.getInstance().getReference().child("Delivery");
        try {
            if (TextUtils.isEmpty(et_name.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please Enter Your Name", Toast.LENGTH_SHORT).show();

            } else if (TextUtils.isEmpty(et_phone.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please Enter Your Contact Number", Toast.LENGTH_SHORT).show();

            } else if (TextUtils.isEmpty(et_email.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please Enter Your email Address", Toast.LENGTH_SHORT).show();

            }  else if (TextUtils.isEmpty(et_ShippingAdd.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please Enter the Shipping Address", Toast.LENGTH_SHORT).show();

            } else if (TextUtils.isEmpty(et_city.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please Enter the city", Toast.LENGTH_SHORT).show();

            } else {
                //take inputs from the user and assigning them to this instance (stuObj) of the student
                delObj.setName(et_name.getText().toString().trim());
                delObj.setPhone(Integer.parseInt(et_phone.getText().toString().trim()));
                delObj.setEmail(et_email.getText().toString().trim());
                delObj.setShippingAddress(et_ShippingAdd.getText().toString().trim());
                delObj.setCity(et_city.getText().toString().trim());


                // navigate to the Delivery_Crud_OP
                Intent intent = new Intent(this, Delivery_Crud_Op.class);

                String name = et_name.getText().toString();
                String phone = et_phone.getText().toString();
                String email = et_email.getText().toString();
                String ShippingAdd = et_ShippingAdd.getText().toString();
                String city = et_city.getText().toString();

                intent.putExtra("name1", name);
                intent.putExtra("phone1", phone);
                intent.putExtra("email1", email);
                intent.putExtra("ShippingAdd1", ShippingAdd);
                intent.putExtra("city1", city);

                startActivity(intent);



                //insert into the database
//              dbRef.push().setValue(stuObj);
                dbRef.child("delivery1").setValue(delObj);

                //Feedback to the user via a Toast...
                Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                ClearControls();
            }


        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
        }

        //-------------------

    }

//============================================================================






}