package com.example.mad_knox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RVActivity_P extends AppCompatActivity {

    // Defining Objects of the UIs
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    RVAdapter_P adapter;
    DAOProduct dao;

    boolean isLoading = false;   // checking for refresh of recycler view

    String key = null;   // for pagination

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvp);

        swipeRefreshLayout = findViewById(R.id.swip);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adapter = new RVAdapter_P(this);
        recyclerView.setAdapter(adapter);
        dao = new DAOProduct();

        // Loading Data
        loadData();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                // returns total item count in the recycler view
                int totalItems = linearLayoutManager.getItemCount();

                // returns the position of the last item
                int lastVisible = linearLayoutManager.findLastCompletelyVisibleItemPosition();

                // Function to refresh the data
                if(totalItems < lastVisible+3){

                    if(!isLoading){
                        isLoading = true;
                        loadData();
                    }

                }
            }
        });
    }

    private void loadData() {

        swipeRefreshLayout.setRefreshing(true);

        dao.get(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ArrayList<ProductData> prods = new ArrayList<>();
                for (DataSnapshot data : snapshot.getChildren()){

                    ProductData prod = data.getValue(ProductData.class);
                    prod.setKey(data.getKey());
                    prods.add(prod);
                    key = data.getKey();
                }
                adapter.setItems(prods);
                adapter.notifyDataSetChanged();
                isLoading = false;
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    // Implementing Recycler View
}