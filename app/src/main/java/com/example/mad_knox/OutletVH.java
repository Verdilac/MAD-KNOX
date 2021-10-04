package com.example.mad_knox;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OutletVH extends RecyclerView.ViewHolder
{
    public TextView txt_name,txt_category, txt_description, txt_location, txt_option;

    public OutletVH(@NonNull View itemView)
    {
        super(itemView);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_category = itemView.findViewById(R.id.txt_category);
        txt_description = itemView.findViewById(R.id.txt_description);
        txt_location = itemView.findViewById(R.id.txt_location);
        txt_option = itemView.findViewById(R.id.txt_option);

    }




}
