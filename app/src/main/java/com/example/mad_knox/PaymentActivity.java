package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PaymentActivity extends AppCompatActivity {

//    DAOCard dao = new DAOCard();
//    TextInputLayout layname;
//    TextInputLayout laycardno;
     EditText holder_name;
     EditText card_no;
    Button btn_pay;
    DatabaseReference dbref;
    Card card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

         card = new Card();
//        layname = findViewById(R.id.holder_namelayout);
//        laycardno = findViewById(R.id.card_nolayout);

        holder_name =   findViewById(R.id.holder_name);
        card_no =  findViewById(R.id.card_no);
        btn_pay = findViewById(R.id.btn_pay);

    }



    public void createData(View view){
        dbref = FirebaseDatabase.getInstance().getReference().child("Card");

        card.setName(holder_name.getText().toString().trim());
        card.setNo(card_no.getText().toString().trim());

        dbref.push().setValue(card);


    }


}
