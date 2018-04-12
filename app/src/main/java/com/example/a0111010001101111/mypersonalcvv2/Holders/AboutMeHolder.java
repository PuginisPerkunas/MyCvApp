package com.example.a0111010001101111.mypersonalcvv2.Holders;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.easyandroidanimations.library.ScaleInAnimation;
import com.example.a0111010001101111.mypersonalcvv2.R;

/**
 * Created by 0111010001101111 on 4/5/2018.
 */

public class AboutMeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView titleTxt, sectonTxt;
    public Typeface fontBold, fontRegular;
    public Context context;
    public long duration = 450;

    public AboutMeHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);
        context = itemView.getContext();
        titleTxt = (TextView) itemView.findViewById(R.id.title_text);
        sectonTxt = (TextView) itemView.findViewById(R.id.section_text);

        fontBold = Typeface.createFromAsset(context.getAssets(), context.getString(R.string.font_name_qucksand_bold));
        fontRegular = Typeface.createFromAsset(context.getAssets(), context.getString(R.string.font_name_qucksand_reg));

        titleTxt.setTypeface(fontBold);
        sectonTxt.setTypeface(fontRegular);

        new ScaleInAnimation(itemView).setDuration(duration).animate();

    }

    @Override
    public void onClick(View view) {

    }
}
