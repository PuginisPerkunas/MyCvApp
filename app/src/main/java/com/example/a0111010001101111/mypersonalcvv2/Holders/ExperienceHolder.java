package com.example.a0111010001101111.mypersonalcvv2.Holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.easyandroidanimations.library.ScaleInAnimation;
import com.example.a0111010001101111.mypersonalcvv2.Models.DataStorage;
import com.example.a0111010001101111.mypersonalcvv2.R;

/**
 * Created by 0111010001101111 on 4/5/2018.
 */

public class ExperienceHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView titleTxt, sectonTxt;
    public ImageView imageExp;
    public DataStorage dataStorage;
    public Context context;
    public long duration = 450;

    public ExperienceHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);

        context = itemView.getContext();
        dataStorage = new DataStorage(context);
        titleTxt = (TextView) itemView.findViewById(R.id.title_text);
        sectonTxt = (TextView) itemView.findViewById(R.id.section_text);
        imageExp = (ImageView) itemView.findViewById(R.id.image_experieance);

        titleTxt.setTypeface(dataStorage.getFontBold());
        sectonTxt.setTypeface(dataStorage.getFontBold());

        new ScaleInAnimation(itemView).setDuration(duration).animate();

    }

    @Override
    public void onClick(View view) {

    }
}
