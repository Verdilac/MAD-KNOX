package com.example.mad_knox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Delivery_Crud_Op extends AppCompatActivity {

    EditText et_name, et_phone, et_email, et_ShippingAdd, et_city;
    //declare the buttons as well
    Button btn_Delivery_View, btn_Delivery_Edit, btn_Delivery_Del ;

    Delivery delObj;
    DatabaseReference dbRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_crud_op);

        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        et_email = findViewById(R.id.et_email);
        et_ShippingAdd = findViewById(R.id.et_ShippingAdd);
        et_city = findViewById(R.id.et_city);

        // declare the buttons as well

        btn_Delivery_View = findViewById(R.id.btn_Delivery_View);
        btn_Delivery_Edit = findViewById(R.id.btn_Delivery_Edit);
        btn_Delivery_Del = findViewById(R.id.btn_Delivery_Del);

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


    // view  data
    public void ViewData(View view){
        dbRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child("delivery1");
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    et_name.setText(dataSnapshot.child("name").getValue().toString());
                    et_phone.setText(dataSnapshot.child("phone").getValue().toString());
                    et_email.setText(dataSnapshot.child("email").getValue().toString());
                    et_ShippingAdd.setText(dataSnapshot.child("shippingAddress").getValue().toString());
                    et_city.setText(dataSnapshot.child("city").getValue().toString());
                }else{
                    Toast.makeText(Delivery_Crud_Op.this, "No source to display", Toast.LENGTH_SHORT).show();
                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


//=====================================================================

    // Update data
    public void UpdateData(View view){
        DatabaseReference updRefDel = FirebaseDatabase.getInstance().getReference().child("Delivery");
        updRefDel.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild("delivery1")){
                    try{
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

                        }

                        else{
                            delObj.setName(et_name.getText().toString().trim());
                            delObj.setPhone(Integer.parseInt(et_phone.getText().toString().trim()));
                            delObj.setEmail(et_email.getText().toString().trim());
                            delObj.setShippingAddress(et_ShippingAdd.getText().toString().trim());
                            delObj.setCity(et_city.getText().toString().trim());

                            dbRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child("delivery1");
                            dbRef.setValue(delObj);
                            ClearControls();
                            Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                    //--------
                    catch (NumberFormatException e){
                        Toast.makeText(getApplicationContext(),"Invalid Phone Number",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(getApplicationContext(),"No Source to Update",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
//======================================================================

    // Delete Data
    public void DeleteData(View view){
        DatabaseReference delRefDelivery = FirebaseDatabase.getInstance().getReference().child("Delivery");
        delRefDelivery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild("delivery1")){
                    dbRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child("delivery1");
                    dbRef.removeValue();
                    ClearControls();
                    Toast.makeText(getApplicationContext(), "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"No Source to Delete",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

//=======================================================================

    // Intent for back to main page in Delivery
    public void backToMainDelivery(View view){
        Intent intent = new Intent(this, Delivery_Main.class);
        startActivity(intent);
    }

//========================================================================

    public void moveToDisplayDelivery(View view){
        Intent intent = new Intent(this, Display_Delivery_Det.class);

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
    }

}