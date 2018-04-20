package com.example.a0111010001101111.mypersonalcvv2.Activities;

import android.content.Intent;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.dynamitechetan.flowinggradient.FlowingGradientClass;
import com.easyandroidanimations.library.Animation;
import com.easyandroidanimations.library.AnimationListener;
import com.easyandroidanimations.library.FadeInAnimation;
import com.example.a0111010001101111.mypersonalcvv2.R;

public class StartActivity extends AppCompatActivity {

    private Button ltBtn, enBtn, ruBtn;
    private RelativeLayout rl;
    Intent intentForActions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        init();
        setListener();

    }

    private void init(){
        ltBtn = (Button) findViewById(R.id.lt_btn);
        enBtn = (Button) findViewById(R.id.en_btn);
        ruBtn = (Button) findViewById(R.id.ru_btn);
        rl = (RelativeLayout) findViewById(R.id.relative_start);
        ltBtn.setVisibility(View.INVISIBLE);
        enBtn.setVisibility(View.INVISIBLE);
        ruBtn.setVisibility(View.INVISIBLE);
        setAnimations(ltBtn,enBtn,ruBtn);
        intentForActions = new Intent(StartActivity.this,MainActivity.class);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    private void setListener(){
        ltBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentForActions.putExtra("lan","lt");
                startActivity(intentForActions);
                finish();
            }
        });

        enBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentForActions.putExtra("lan","en");
                startActivity(intentForActions);
                finish();
            }
        });

        ruBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentForActions.putExtra("lan","ru");
                startActivity(intentForActions);
                finish();
            }
        });
    }

    private void setAnimations(Button lt, final Button en, final Button ru){
        new FadeInAnimation(lt).setDuration(800).setListener(new AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                new FadeInAnimation(en).setDuration(500).setListener(new AnimationListener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        new FadeInAnimation(ru).setDuration(400).animate();
                    }
                }).animate();
            }
        }).animate();

        FlowingGradientClass fg = new FlowingGradientClass()
                .setBackgroundResource(R.drawable.trans)
                .onRelativeLayout(rl)
                .setTransitionDuration(4000)
                .start();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            View decorView = this.getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
