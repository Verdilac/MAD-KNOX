package com.example.mad_knox;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardVH  extends RecyclerView.ViewHolder {

    public TextView txt_name,txt_number;

    public CardVH(@NonNull View itemView) {
        super(itemView);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_number = itemView.findViewById(R.id.txt_number);

    }
}
