package com.example.mad_knox;

import android.content.Context;
import android.content.Intent;
import android.text.style.UpdateAppearance;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

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
        vh.txt_option.setOnClickListener(v->
        {
            PopupMenu popupMenu =new PopupMenu(context, vh.txt_option);
            popupMenu.inflate(R.menu.option_menu);
            popupMenu.setOnMenuItemClickListener(item->
            {
                switch (item.getItemId())
                {
                    case R.id.menu_update:
                        Intent intent = new Intent (context,CreateSellerOutlet_k.class);
                        intent.putExtra("UPDATE" ,out);
                        context.startActivity(intent);

                        break;

                    case R.id.menu_delete:
                        DAOOutlet dao=new DAOOutlet();
                        dao.remove(out.getKey()).addOnSuccessListener(suc->
                        {
                            Toast.makeText(context, "Record deleted successfully", Toast.LENGTH_SHORT).show();
                            notifyItemRemoved(position);
                        }).addOnFailureListener(er->
                        {
                            Toast.makeText(context, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
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
