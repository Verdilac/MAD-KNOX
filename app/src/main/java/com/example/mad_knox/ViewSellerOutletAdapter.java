package com.example.mad_knox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewSellerOutletAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    ArrayList<Outlet> list = new ArrayList<>();
    public ViewSellerOutletAdapter(Context ctx)
    {
        this.context = ctx;

    }
    public void setItems(ArrayList<Outlet> out)
    {
        list.addAll(out);

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new OutletVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        OutletVH vh = (OutletVH) holder;
        Outlet out = list.get(position);
        vh.txt_name.setText(out.getName());
        vh.txt_category.setText(out.getCategory());
        vh.txt_description.setText(out.getDescription());
        vh.txt_location.setText(out.getLocation());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
