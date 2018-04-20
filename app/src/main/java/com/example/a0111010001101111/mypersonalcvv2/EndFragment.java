package com.example.a0111010001101111.mypersonalcvv2;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.easyandroidanimations.library.Animation;
import com.easyandroidanimations.library.AnimationListener;
import com.easyandroidanimations.library.PuffInAnimation;
import com.easyandroidanimations.library.ScaleOutAnimation;
import com.example.a0111010001101111.mypersonalcvv2.Activities.MainActivity;
import com.example.a0111010001101111.mypersonalcvv2.Models.DataStorage;


/**
 * A simple {@link Fragment} subclass.
 */
public class EndFragment extends Fragment implements MainMethods {

    TextView endTitle, explainText, emailText, emailTextActual, phoneText, phoneTextActual, facebookText, facebookTextActual;
    Button emailButton, phoneButton, facebookButton;
    CardView cardOne, cardTwo, cardThree;
    View view;
    Context context;
    DataStorage dataStorage;
    Intent intentForActions;
    String[] emailToSend ;
    Uri uriFacebook ;
    int buttonsDuration = 150, cardOneDuration = 500, cardTwoDuration = 350, cardThreeDuration = 250;

    public EndFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_end,container,false);
        init();
        setFactorys();
        setListeners();
        setAnimations();
        return view;
    }

    @Override
    public void init() {

        uriFacebook = Uri.parse(getResources().getString(R.string.facebook_link));

        context = getContext();
        dataStorage = new DataStorage(context);

        cardOne = view.findViewById(R.id.card_end_one);
        cardTwo = view.findViewById(R.id.card_end_two);
        cardThree = view.findViewById(R.id.card_end_three);

        cardOne.setVisibility(View.INVISIBLE);
        cardTwo.setVisibility(View.INVISIBLE);
        cardThree.setVisibility(View.INVISIBLE);

        endTitle = view.findViewById(R.id.end_title);
        explainText = view.findViewById(R.id.end_explain_text);
        emailText = view.findViewById(R.id.my_email_text);
        emailTextActual = view.findViewById(R.id.end_frag_email_text);
        phoneText = view.findViewById(R.id.my_phone_text);
        phoneTextActual = view.findViewById(R.id.end_frag_phone_text);
        facebookText = view.findViewById(R.id.my_facebook_text);
        facebookTextActual = view.findViewById(R.id.end_frag_facebook_text);

        emailButton = view.findViewById(R.id.end_email_button);
        phoneButton = view.findViewById(R.id.end_phone_button);
        facebookButton = view.findViewById(R.id.end_facebook_button);
    }

    @Override
    public void setListeners() {

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ScaleOutAnimation(emailButton).setDuration(buttonsDuration).setListener(new AnimationListener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        new PuffInAnimation(emailButton).setDuration(buttonsDuration).animate();

                        emailToSend = new String[] {getString(R.string.my_email)};
                        intentForActions = new Intent(Intent.ACTION_SEND);
                        intentForActions.setType("message/rfc822");
                        intentForActions.putExtra(Intent.EXTRA_EMAIL, emailToSend );
                        intentForActions.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
                        Intent mail = Intent.createChooser(intentForActions, null);
                        startActivity(mail);
                    }
                }).animate();
            }
        });

        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ScaleOutAnimation(phoneButton).setDuration(buttonsDuration).setListener(new AnimationListener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        new PuffInAnimation(phoneButton).setDuration(buttonsDuration).animate();
                        intentForActions = new Intent(Intent.ACTION_DIAL);
                        intentForActions.setData(Uri.parse("tel:" + getString(R.string.my_phone_number)));
                        startActivity(intentForActions);
                    }
                }).animate();
            }
        });

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ScaleOutAnimation(facebookButton).setDuration(buttonsDuration).setListener(new AnimationListener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        new PuffInAnimation(facebookButton).setDuration(buttonsDuration).animate();
                        intentForActions = new Intent(Intent.ACTION_VIEW, uriFacebook);
                        startActivity(intentForActions);
                    }
                }).animate();
            }
        });

    }

    @Override
    public void setFactorys() {

        endTitle.setTypeface(dataStorage.getFontBold());
        emailButton.setTypeface(dataStorage.getFontBold());
        phoneButton.setTypeface(dataStorage.getFontBold());
        facebookButton.setTypeface(dataStorage.getFontBold());
        explainText.setTypeface(dataStorage.getFontRegular());
        emailText.setTypeface(dataStorage.getFontRegular());
        emailTextActual.setTypeface(dataStorage.getFontRegular());
        phoneText.setTypeface(dataStorage.getFontRegular());
        phoneTextActual.setTypeface(dataStorage.getFontRegular());
        facebookText.setTypeface(dataStorage.getFontRegular());
        facebookTextActual.setTypeface(dataStorage.getFontRegular());
    }

    private void setAnimations(){
        new PuffInAnimation(cardOne).setDuration(cardOneDuration).setListener(new AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                new PuffInAnimation(cardTwo).setDuration(cardTwoDuration).setListener(new AnimationListener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        new PuffInAnimation(cardThree).setDuration(cardTwoDuration).animate();
                    }
                }).animate();
            }
        }).animate();
    }
}
