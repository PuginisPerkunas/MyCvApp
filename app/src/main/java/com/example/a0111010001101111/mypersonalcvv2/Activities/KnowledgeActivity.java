package com.example.a0111010001101111.mypersonalcvv2.Activities;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a0111010001101111.mypersonalcvv2.KnowledgeFragments.AndroidStudioFragment;
import com.example.a0111010001101111.mypersonalcvv2.KnowledgeFragments.GithubFragment;
import com.example.a0111010001101111.mypersonalcvv2.KnowledgeFragments.ReactNativeFragment;
import com.example.a0111010001101111.mypersonalcvv2.KnowledgeFragments.UnityFragment;
import com.example.a0111010001101111.mypersonalcvv2.KnowledgeFragments.VisualStudioFragment;
import com.example.a0111010001101111.mypersonalcvv2.Models.DataStorage;
import com.example.a0111010001101111.mypersonalcvv2.R;

import java.util.Locale;

public class KnowledgeActivity extends AppCompatActivity {

    BottomNavigationView navigation;
    android.support.v4.app.FragmentManager fragmentManager;

    DataStorage dataStorage;
    private TextView mTextMessage;
    private ImageView buttonBack;

    private int contentId = R.id.content_frame_knowledge;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right);

            switch (item.getItemId()) {
                case R.id.nav_android_studio:
                    mTextMessage.setText(R.string.title_android_studio);
                    ft.replace(contentId, new AndroidStudioFragment());
                    ft.commit();
                    return true;
                case R.id.nav_react_native:
                    mTextMessage.setText(R.string.title_react_native);
                    ft.replace(contentId, new ReactNativeFragment());
                    ft.commit();
                    return true;
                case R.id.nav_visual_studio:
                    mTextMessage.setText(R.string.title_visual_studio);
                    ft.replace(contentId, new VisualStudioFragment());
                    ft.commit();
                    return true;
                case R.id.nav_unity:
                    mTextMessage.setText(R.string.title_unity);
                    ft.replace(contentId, new UnityFragment());
                    ft.commit();
                    return true;
                case R.id.nav_github:
                    mTextMessage.setText(R.string.title_github);
                    ft.replace(contentId,new GithubFragment());
                    ft.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_knowledge);
        init();
        setListeners();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        dataStorage = new DataStorage(this);
        mTextMessage.setTypeface(dataStorage.getFontBold());

        fragmentManager.beginTransaction()
                .replace(contentId, new AndroidStudioFragment())
                .commit();

    }

    private void init(){
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        buttonBack = (ImageView) findViewById(R.id.back_button);
        mTextMessage = (TextView) findViewById(R.id.message);
    }

    private void setListeners(){
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentManager = getSupportFragmentManager();
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
