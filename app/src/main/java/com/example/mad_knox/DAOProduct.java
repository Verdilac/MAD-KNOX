package com.example.mad_knox;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DAOProduct {

    private DatabaseReference databaseReference;

    public DAOProduct(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(ProductData.class.getSimpleName());   // Returns the class name
    }

    // Insertion
    public Task<Void> add(ProductData prod){

        // Include Validations here
        return databaseReference.push().setValue(prod);
    }

    // Update
    public Task<Void> update(String key, HashMap<String, Object> hashMap){

        return databaseReference.child(key).updateChildren(hashMap);
    }

    // Deletion
    public Task<Void> remove(String key){

        return databaseReference.child(key).removeValue();
    }


}
