package com.example.mad_knox;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class DAOCard {

    private DatabaseReference databaseReference;

    public  DAOCard(){

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Cards");
    }

    public Query get(){
        return  databaseReference.orderByKey();
    }


}
