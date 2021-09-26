//package com.example.mad_knox;
//
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//public class DAOCard {
//
//    private DatabaseReference databaseReference;
//
//    public DAOCard(){
//        FirebaseDatabase db = FirebaseDatabase.getInstance();
//        databaseReference = db.getReference(Card.class.getSimpleName());
//    }
//
//    public Task<Void> add(Card card){
//
//        return databaseReference.push().setValue(card);
//    }
//
//}