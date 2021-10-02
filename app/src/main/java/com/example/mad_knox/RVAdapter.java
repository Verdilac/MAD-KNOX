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

        vh.txt_option.setOnClickListener(v->{
            PopupMenu popupMenu = new PopupMenu(context,vh.txt_option);
            popupMenu.inflate(R.menu.option_menu);
            popupMenu.setOnMenuItemClickListener(item->{

                switch (item.getItemId())
                {
                    case R.id.menu_edit:
                        Intent intent = new Intent(context,Cardpayment.class);
                        intent.putExtra("EDIT",card);
                        context.startActivity(intent);
                        break;
                    case R.id.menu_remove:
                        DAOCard dao = new DAOCard();
                        dao.remove(card.getKey()).addOnSuccessListener(suc->{
                            Toast.makeText(context, "Record Removed", Toast.LENGTH_SHORT).show();
                        }).addOnFailureListener(er->{
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
