package com.example.mad_knox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    private Context context;
    ArrayList<Card> list = new ArrayList<>();


    public RVAdapter(Context ctx)
    {
        this.context = ctx;
    }

    public  void  setItems(ArrayList<Card> card){
        list.addAll(card);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return  new CardVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        CardVH vh = (CardVH) holder;
        Card card = list.get(position);

        vh.txt_name.setText(card.getName());
        vh.txt_number.setText(card.getNo());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
