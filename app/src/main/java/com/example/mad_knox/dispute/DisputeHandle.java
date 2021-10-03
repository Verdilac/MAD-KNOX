package com.example.mad_knox.dispute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mad_knox.R;

public class DisputeHandle extends AppCompatActivity {


    String reason,experience;
    Dispute dispute;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispute_handle);


        EditText edit_reason = findViewById(R.id.edit_reason);
        EditText edit_experience = findViewById(R.id.edit_experience);


        Button btn_dispute = findViewById(R.id.btn_disputesubmit);


        dispute = new Dispute();
        DAODispute dao = new DAODispute();

        btn_dispute.setOnClickListener(v->{

            reason = edit_reason.getText().toString().trim();
            experience = edit_experience.getText().toString().trim();

            dispute.setReason(reason);
            dispute.setExperience(experience);

            dao.add(dispute).addOnSuccessListener(suc->{
                Toast.makeText(this, "Dispute Submitted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });


        });


    }
}