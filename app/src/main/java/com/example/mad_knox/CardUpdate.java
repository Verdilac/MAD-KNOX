package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class CardUpdate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_update);


        final EditText edit_name = findViewById(R.id.edit_name);
        final EditText edit_no = findViewById(R.id.edit_no);


        Button btnUpdate = findViewById(R.id.btn_update);

        DAOCard dao = new DAOCard();
        Card card_edit =  (Card) getIntent().getSerializableExtra("EDIT");

        if(card_edit != null){
            edit_name.setText(card_edit.getName());
            edit_no.setText(card_edit.getNo());
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