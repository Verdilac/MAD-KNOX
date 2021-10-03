package com.example.mad_knox.dispute;

import com.example.mad_knox.Card;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAODispute {

        private DatabaseReference databaseReference;

        public  DAODispute(){
            databaseReference = FirebaseDatabase.getInstance().getReference().child("Dispute");
        }




    public Task<Void> add(Dispute dispute){

        return databaseReference.push().setValue(dispute);
    }


}
