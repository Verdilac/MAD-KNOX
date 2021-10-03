package com.example.mad_knox.dispute;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mad_knox.R;

import java.util.ArrayList;

public class RVAdaperDispute extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    ArrayList<Dispute> list = new ArrayList<>();
    public RVAdaperDispute(Context ctx){
        this.context = ctx;
    }

    public  void  setItems(ArrayList<Dispute> dispute){
        list.addAll(dispute);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.layout_dispute,parent,false);
        return  new DisputeVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        DisputeVH vh  = (DisputeVH) holder;
        Dispute dispute = list.get(position);
        vh.txt_reason.setText(dispute.getReason());
        vh.txt_experience.setText(dispute.getExperience());
        vh.txt_disoption.setOnClickListener(v->{
            PopupMenu popupMenu = new PopupMenu(context,vh.txt_disoption);
            popupMenu.inflate(R.menu.disoption_menu);
            popupMenu.setOnMenuItemClickListener(item->{

                switch (item.getItemId()){
                    case R.id.menu_resolved:
                        DAODispute dao = new DAODispute();
                        dao.remove(dispute.getKey()).addOnSuccessListener(suc->{
                            Toast.makeText(context, "Dispute Resolved", Toast.LENGTH_SHORT).show();

                        }).addOnFailureListener(er->{
                            Toast.makeText(context, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
                        });


                        break;

                }
                return  false;
            });
            popupMenu.show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
