package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class CardUpdate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_update);


        final EditText edit_name = findViewById(R.id.edit_name);
        final EditText edit_no = findViewById(R.id.edit_no);
        final  EditText edit_month = findViewById(R.id.edit_month);
        final  EditText edit_year = findViewById(R.id.edit_year);
        final  EditText edit_cvv = findViewById(R.id.edit_cvv);


        Button btnUpdate = findViewById(R.id.btn_update);

        DAOCard dao = new DAOCard();
        Card card_edit =  (Card) getIntent().getSerializableExtra("EDIT");

        if(card_edit != null){

            edit_name.setText(card_edit.getName());
            edit_no.setText(card_edit.getNo());
            edit_month.setText(card_edit.getMonth());
            edit_year.setText(card_edit.getYear());
            edit_cvv.setText(card_edit.getCvv());

        }



        btnUpdate.setOnClickListener(v->{


            HashMap<String,Object> hashMap = new HashMap<>();
            //make sure to test without trimming methode.
            hashMap.put("name",edit_name.getText().toString());
            hashMap.put("no",edit_no.getText().toString());


            dao.update(card_edit.getKey(),hashMap).addOnSuccessListener(suc->{
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                finish();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });



        });








    }
}