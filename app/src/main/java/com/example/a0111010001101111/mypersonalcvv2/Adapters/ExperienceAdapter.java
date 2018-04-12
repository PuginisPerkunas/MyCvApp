package com.example.a0111010001101111.mypersonalcvv2.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a0111010001101111.mypersonalcvv2.Holders.ExperienceHolder;
import com.example.a0111010001101111.mypersonalcvv2.Models.ExperienceItemObjet;
import com.example.a0111010001101111.mypersonalcvv2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 0111010001101111 on 4/5/2018.
 */

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceHolder> {
    private List<ExperienceItemObjet> itemsList;
    private Context context;
    private View layoutView;


    public ExperienceAdapter(Context context, List<ExperienceItemObjet> itemsList) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @Override
    public ExperienceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        layoutView = LayoutInflater.from(context).inflate(R.layout.experience_item,null);
        ExperienceHolder experienceHolder = new ExperienceHolder(layoutView);
        return experienceHolder;
    }

    @Override
    public void onBindViewHolder(ExperienceHolder holder, int position) {
        holder.titleTxt.setText(itemsList.get(position).getTitle());
        holder.sectonTxt.setText(itemsList.get(position).getSectionText());
        Picasso.with(context).load(itemsList.get(position).getImageName()).into(holder.imageExp);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}
