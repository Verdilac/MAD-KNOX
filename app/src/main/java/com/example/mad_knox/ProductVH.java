package com.example.mad_knox;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductVH extends RecyclerView.ViewHolder {


    public TextView txt_name, txt_location, txt_price, txt_option;

    public ProductVH(@NonNull View itemView) {
        super(itemView);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_location = itemView.findViewById(R.id.txt_location);
        txt_price = itemView.findViewById(R.id.txt_price);
        txt_option = itemView.findViewById(R.id.txt_option);
    }
}
