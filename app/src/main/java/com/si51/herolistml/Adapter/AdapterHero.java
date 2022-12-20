package com.si51.herolistml.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.si51.herolistml.Model.HeroModel;
import com.si51.herolistml.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterHero extends RecyclerView.Adapter<AdapterHero.HolderData> {
    private List<HeroModel> listModel = new ArrayList<>();
    public AdapterHero(List<HeroModel> listModel) {
        this.listModel = listModel;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View layout = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item_hero, parent, false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        HeroModel QM = listModel.get(position);
        holder.tvHero.setText(QM.getHero_name());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(),
                        "Author : "+ QM.getAuthor(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ListModel.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView tvHero;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            tvHero = itemView.findViewById(R.id.tv_hero);

        }
    }
}
