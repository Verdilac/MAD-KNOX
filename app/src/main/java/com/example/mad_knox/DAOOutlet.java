package com.example.mad_knox;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOOutlet {

    private DatabaseReference databaseReference;
            public DAOOutlet()
            {
                FirebaseDatabase db =FirebaseDatabase.getInstance();
                databaseReference = db.getReference(Outlet.class.getSimpleName());
            }

            public Task<Void> add(Outlet out)
            {
                return databaseReference.push().setValue(out);

            }
}
