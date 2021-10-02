package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashMap;

public class Cardpayment extends AppCompatActivity {

    TextInputLayout holdername;
    TextInputLayout cardno;
    TextInputLayout cardmonthlay;
    TextInputLayout cardyearlay;
    TextInputLayout cardcvvlay;
    Button btn_pay;
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
//      Card card_edit = (Card) getIntent().getSerializableExtra("EDIT");

        DAOCard dao = new DAOCard();
        btn_pay = findViewById(R.id.btn_pay);
        btn_pay.setOnClickListener(v->{


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
            dao.add(card).addOnSuccessListener(suc->{
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });


//            HashMap<String,Object> hashMap = new HashMap<>();
//            //make sure to test without trimming methode.
//            hashMap.put("name",name);
//            hashMap.put("no",cardnumber);
//            hashMap.put("month",cardmonth);
//            hashMap.put("year",cardyear);
//            hashMap.put("cvv",cardcvv);
//
//            dao.update("-Mkzjg11hS6WJnDDXWi7",hashMap).addOnSuccessListener(suc->{
//                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
//            }).addOnFailureListener(er->{
//                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
//            });


//            dao.remove("-Mkzjg11hS6WJnDDXWi7").addOnSuccessListener(suc->{
//                Toast.makeText(this, "Record Removed", Toast.LENGTH_SHORT).show();
//            }).addOnFailureListener(er->{
//                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
//            });



        });



    }
//    public void CardDataSubmission(View view){
//
//
//        name = holdername.getEditText().getText().toString().trim();
//        cardnumber = cardno.getEditText().getText().toString().trim();
//        cardmonth = cardmonthlay.getEditText().getText().toString().trim();
//        cardyear = cardyearlay.getEditText().getText().toString().trim();
//        cardcvv = cardcvvlay.getEditText().getText().toString().trim();
//
//        card.setName(name);
//        card.setNo(cardnumber);
//        card.setMonth(cardmonth);
//        card.setYear(cardyear);
//        card.setCvv(cardcvv);
//
//        dbref.push().setValue(card);
//    }




}