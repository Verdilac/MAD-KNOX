package com.example.mad_knox.dispute;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mad_knox.R;

public class DisputeVH extends RecyclerView.ViewHolder {


    public TextView txt_reason,txt_experience,txt_disoption;

    public DisputeVH(@NonNull View itemView) {
        super(itemView);
        txt_reason = itemView.findViewById(R.id.txt_reason);
        txt_experience = itemView.findViewById(R.id.txt_experience);
        txt_disoption = itemView.findViewById(R.id.txt_disoption);

    }
}
