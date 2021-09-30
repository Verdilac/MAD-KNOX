package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Cardpayment extends AppCompatActivity {

    TextInputLayout holdername;
    TextInputLayout cardno;
    TextInputLayout cardmonthlay;
    TextInputLayout cardyearlay;
    TextInputLayout cardcvvlay;
    String name;
    String cardnumber;
    String cardmonth;
    String cardyear;
    String cardcvv;
    Card card;
    DatabaseReference dbref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardpayment);


        card = new Card();
        cardno = findViewById(R.id.card_nolayout);
        holdername = findViewById(R.id.holder_namelayout);
        cardmonthlay = findViewById(R.id.cardmonth);
        cardyearlay = findViewById(R.id.cardyear);
        cardcvvlay = findViewById(R.id.cardcvv);

    }
    public void CardDataSubmission(View view){
        dbref = FirebaseDatabase.getInstance().getReference().child("Cards");

        name = holdername.getEditText().getText().toString().trim();
        cardnumber = cardno.getEditText().getText().toString().trim();
        cardmonth = cardmonthlay.getEditText().getText().toString().trim();
        cardyear = cardyearlay.getEditText().getText().toString().trim();
        cardcvv = cardcvvlay.getEditText().getText().toString().trim();

        card.setName(name);
        card.setNo(cardnumber);
        card.setMonth(cardmonth);
        card.setYear(cardyear);
        card.setCvv(cardcvv);

        dbref.push().setValue(card);
    }




}