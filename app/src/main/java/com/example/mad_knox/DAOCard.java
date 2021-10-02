package com.example.mad_knox;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class DAOCard {

    private DatabaseReference databaseReference;

    public  DAOCard(){


        databaseReference = FirebaseDatabase.getInstance().getReference().child("Cards");
    }


    public Task<Void> add(Card card){

         return databaseReference.push().setValue(card);
    }

    public  Task<Void> update(String key, HashMap<String,Object> hashMap){

//        make sure to test with changed db reference
       return databaseReference.child(key).updateChildren(hashMap);

    }

    public Task<Void> remove(String key){
        return  databaseReference.child(key).removeValue();
    }



    public Query get(String key){

        if(key == null){
            return databaseReference.orderByKey().limitToFirst(8);
        }
        return databaseReference.orderByKey().startAfter(key).limitToFirst(8);
    }




}
