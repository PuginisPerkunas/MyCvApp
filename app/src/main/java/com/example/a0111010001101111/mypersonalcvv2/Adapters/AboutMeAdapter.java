package com.example.a0111010001101111.mypersonalcvv2.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a0111010001101111.mypersonalcvv2.Holders.AboutMeHolder;
import com.example.a0111010001101111.mypersonalcvv2.Models.AboutMeItemObject;
import com.example.a0111010001101111.mypersonalcvv2.R;

import java.util.List;

/**
 * Created by 0111010001101111 on 4/5/2018.
 */

public class AboutMeAdapter extends RecyclerView.Adapter<AboutMeHolder> {
    private List<AboutMeItemObject> itemsList;
    private Context context;
    private View layoutView;

    public AboutMeAdapter(Context context, List<AboutMeItemObject> itemsList) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @Override
    public AboutMeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        layoutView = LayoutInflater.from(context).inflate(R.layout.about_me_item,null);
        AboutMeHolder aboutMeHolder = new AboutMeHolder(layoutView);
        return aboutMeHolder;
    }

    @Override
    public void onBindViewHolder(AboutMeHolder holder, int position) {
        holder.titleTxt.setText(itemsList.get(position).getTitle());
        holder.sectonTxt.setText(itemsList.get(position).getSectionText());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}
