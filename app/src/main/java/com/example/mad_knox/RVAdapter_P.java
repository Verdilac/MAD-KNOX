package com.example.mad_knox;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter_P extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    ArrayList<ProductData> list = new ArrayList<>();

    // Constructor
    public RVAdapter_P(Context ctx){
        this.context = ctx;
    }

    // Appending Data into Array List
    public void setItems(ArrayList<ProductData> prod){
        list.addAll(prod);
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_items_p,parent,false);
        return new ProductVH(view);
    }

    // Binding Data with layout_items
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ProductVH vh = (ProductVH) holder;
        ProductData prod = list.get(position);

        vh.txt_name.setText(prod.getProduct_Name());
        vh.txt_location.setText(prod.getProduct_Location());
        vh.txt_price.setText(String.valueOf(prod.getProduct_Price()));
        vh.txt_option.setOnClickListener(v -> {

            PopupMenu popupMenu = new PopupMenu(context, vh.txt_option);
            popupMenu.inflate(R.menu.option_menu_p);
            popupMenu.setOnMenuItemClickListener(item -> {

                // Switch statement between edit and delete
                switch (item.getItemId()){

                    case R.id.menu_edit:

                        Intent intent = new Intent(context, Product_Details_Page.class);
                        intent.putExtra("EDIT",prod);
                        context.startActivity(intent);
                        break;

                    case R.id.menu_remove:
                        DAOProduct dao = new DAOProduct();
                        dao.remove(prod.getKey()).addOnSuccessListener(suc -> {

                            Toast.makeText(context, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                            notifyItemRemoved(position);

                        }).addOnFailureListener(er -> {

                            Toast.makeText(context, ""+er.getMessage(), Toast.LENGTH_SHORT).show();    // Toasts the error
                        });

                        break;
                }
                return false;
            });
            popupMenu.show();
        });

    }

    @Override
    public int getItemCount() {

        return list.size();
    }
}
