package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Cardpayment extends AppCompatActivity {

    TextInputLayout holdername;
    TextInputLayout cardno;
    String name;
    String cardnumber;
    Card card;
    DatabaseReference dbref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardpayment);


        card = new Card();
        cardno = findViewById(R.id.card_nolayout);
        holdername = findViewById(R.id.holder_namelayout);

    }
    public void CardDataSubmission(View view){
        dbref = FirebaseDatabase.getInstance().getReference().child("Cards");

        name = holdername.getEditText().getText().toString().trim();
        cardnumber = cardno.getEditText().getText().toString().trim();

        card.setName(name);
        card.setNo(cardnumber);

        dbref.push().setValue(card);
    }




}