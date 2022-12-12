package com.si51.herolistml.Adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.si51.herolistml.Model.ListModel;
import com.si51.herolistml.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterHero extends RecyclerView.Adapter<AdapterHero.HolderData> {
    private List<ListModel> listModel = new ArrayList<>();
    public AdapterHero(List<ListModel> listModel) {
        this.listModel =listModel;
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
}
