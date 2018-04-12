package com.example.a0111010001101111.mypersonalcvv2;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.easyandroidanimations.library.Animation;
import com.easyandroidanimations.library.AnimationListener;
import com.easyandroidanimations.library.BounceAnimation;
import com.easyandroidanimations.library.ScaleInAnimation;


/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {

    View view;
    DrawerLayout drawer;
    CardView cardView, second_card;
    Context context;
    Typeface typefaceBold,typefaceReg;
    TextView firstText, askText, becouseTxt, workTxt, prakticTxt,
            textSecondCardBig, textSecondCardSecond;
    Button secondCardButton;

    public StartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_start, container, false);
        init();
        setFactorys();
        playAnimations();
        setListeners();
        return view;
    }

    public void init(){
        context = getContext();
        firstText = view.findViewById(R.id.start_frag_first_text);
        becouseTxt = view.findViewById(R.id.becouse_txt);
        askText = view.findViewById(R.id.ask_text);
        workTxt = view.findViewById(R.id.work_txt);
        prakticTxt = view.findViewById(R.id.praktic_txt);
        cardView = view.findViewById(R.id.start_card);
        second_card = view.findViewById(R.id.second_card);
        textSecondCardBig = view.findViewById(R.id.text_second_card);
        textSecondCardSecond = view.findViewById(R.id.second_card_second_text);
        secondCardButton = view.findViewById(R.id.second_card_button);
        drawer = getActivity().findViewById(R.id.drawer_layout);

        firstText.setVisibility(View.INVISIBLE);
        cardView.setVisibility(View.INVISIBLE);
        second_card.setVisibility(View.INVISIBLE);
    }


    private void setFactorys(){
        typefaceBold = Typeface.createFromAsset(context.getAssets(),getString(R.string.font_name_qucksand_bold));
        typefaceReg = Typeface.createFromAsset(context.getAssets(), getString(R.string.font_name_qucksand_reg));

        firstText.setTypeface(typefaceBold);
        becouseTxt.setTypeface(typefaceBold);
        askText.setTypeface(typefaceReg);
        workTxt.setTypeface(typefaceReg);
        prakticTxt.setTypeface(typefaceReg);
        textSecondCardBig.setTypeface(typefaceBold);
        textSecondCardSecond.setTypeface(typefaceReg);
        secondCardButton.setTypeface(typefaceBold);

    }

    private void playAnimations(){
       new ScaleInAnimation(firstText).setDuration(800).setListener(new AnimationListener() {
           @Override
           public void onAnimationEnd(Animation animation) {
               new ScaleInAnimation(cardView).setDuration(500).setListener(new AnimationListener() {
                   @Override
                   public void onAnimationEnd(Animation animation) {
                       new ScaleInAnimation(second_card).setDuration(500).animate();
                   }
               }).animate();
           }
       }).animate();
    }

    private void setListeners(){
        secondCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
    }

}
