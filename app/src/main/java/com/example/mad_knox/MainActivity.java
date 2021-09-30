package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText no;
    Button submit,redirect;
    DatabaseReference dbref;
    Card card;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //INITILIZIATION

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        card = new Card();


        name = findViewById(R.id.name);
        no = findViewById(R.id.no);
        submit = findViewById(R.id.submit);
        redirect = findViewById(R.id.redirection);

    }

    public void InsertData(View view){
        dbref = FirebaseDatabase.getInstance().getReference().child("Cards");

        card.setName(name.getText().toString().trim());
        card.setNo(no.getText().toString().trim());

        dbref.push().setValue(card);
    }

    public void redirection (View view){
        Intent intent = new Intent(this,Cardpayment.class);
        startActivity(intent);
    }

}