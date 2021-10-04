package com.example.mad_knox;


import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

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

            public Task<Void> update(String key, HashMap<String ,Object> hashMap)
            {
                return databaseReference.child(key).updateChildren(hashMap);
            }

            public Task<Void> remove(String key)
            {
                return databaseReference.child(key).removeValue();
            }

            public Query get(String key)
            {
                if(key == null)
                {
                    return databaseReference.orderByKey().limitToFirst(3);

                }
                return databaseReference.orderByKey().startAfter(key).limitToFirst(3);



            }

}
