package com.example.a0111010001101111.mypersonalcvv2.Activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a0111010001101111.mypersonalcvv2.AboutMeFragment;
import com.example.a0111010001101111.mypersonalcvv2.EndFragment;
import com.example.a0111010001101111.mypersonalcvv2.ExperienceFragment;
import com.example.a0111010001101111.mypersonalcvv2.Models.DataStorage;
import com.example.a0111010001101111.mypersonalcvv2.R;
import com.example.a0111010001101111.mypersonalcvv2.StartFragment;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    View headerView;
    android.support.v4.app.FragmentManager fragmentManager;
    FragmentTransaction ft;

    Typeface typefaceBold,typefaceReg;
    Uri uriFacebook ;
    String[] emailToSend ;
    Intent intentForActions;

    TextView navHeaderText, navHeaderTextAf, footerItemText;
    ImageView navImagePortfolio;
    LinearLayout navFooter;

    DataStorage dataStorage;
    String langueSelected, langueToPass;


    boolean comeFromAct;
    public static Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        langueSelected = getIntent().getStringExtra("lan");
        Log.d("langue selected", langueSelected);
        setLanguage(langueSelected);

        setContentView(R.layout.activity_main);

        init();
        setFactorys();
        setListeners();
        setSupportActionBar(toolbar);

        if(comeFromAct){
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new StartFragment())
                    .commit();
            getSupportActionBar().setTitle(getString(R.string.frag_start));
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new EndFragment())
                    .commit();
            getSupportActionBar().setTitle(getString(R.string.title_end_toolbar));
        }


        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navFooter.setClickable(true);
    }


    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
    }

    private void setLanguage(String language){

        if(language.equals("en")){
            langueToPass = "en";
            setLocale("en");
        } else if (language.equals("lt")){
            langueToPass = "lt";
            setLocale("lt");
        } else if (language.equals("ru")){
            langueToPass = "ru";
            setLocale("ru");
        } else {
            langueToPass = "en";
            setLocale("en");
        }
    }

    public void init(){
        comeFromAct = false;
        resources = getResources();
        fragmentManager = getSupportFragmentManager();
        setSupportActionBar(toolbar);
        dataStorage = new DataStorage(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        fragmentManager = getSupportFragmentManager();

        headerView = navigationView.getHeaderView(0);

        navHeaderText = headerView.findViewById(R.id.nav_header_text);
        navHeaderTextAf = headerView.findViewById(R.id.nav_header_af_text);
        navImagePortfolio = headerView.findViewById(R.id.nav_image_portfolio);
        footerItemText = (TextView) findViewById(R.id.footer_item_text);
        navFooter = (LinearLayout)  findViewById(R.id.nav_footer);
        uriFacebook = Uri.parse(getString(R.string.facebook_link));
    }

    public void setFactorys(){
        typefaceBold = dataStorage.getFontBold();
        typefaceReg = dataStorage.getFontRegular();
        navHeaderText.setTypeface(typefaceBold);
        navHeaderTextAf.setTypeface(typefaceReg);
        footerItemText.setTypeface(typefaceReg);
    }

    public void setListeners(){
        navFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentForActions = new Intent(Intent.ACTION_VIEW, uriFacebook);
                startActivity(intentForActions);
            }
        });
        navImagePortfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uncheckMenuItems();
                ft = fragmentManager.beginTransaction();
                ft.setCustomAnimations(android.R.animator.fade_in,android.R.animator.fade_out);

                ft.replace(R.id.content_frame, new StartFragment());
                ft.commit();

                drawer.closeDrawer(GravityCompat.START);
                getSupportActionBar().setTitle(getString(R.string.frag_start));
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_language) {
            intentForActions = new Intent(MainActivity.this, StartActivity.class);
            startActivity(intentForActions);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about_me) {
            ft = fragmentManager.beginTransaction();
            ft.setCustomAnimations(android.R.animator.fade_in,android.R.animator.fade_out);
            ft.replace(R.id.content_frame, new AboutMeFragment());
            ft.commit();
            getSupportActionBar().setTitle(getString(R.string.frag_about_me));
        } else if (id == R.id.nav_ecperience) {
            ft = fragmentManager.beginTransaction();
            ft.setCustomAnimations(android.R.animator.fade_in,android.R.animator.fade_out);
            ft.replace(R.id.content_frame, new ExperienceFragment());
            ft.commit();
            getSupportActionBar().setTitle(getString(R.string.frag_experience));
        } else if (id == R.id.nav_knowledge) {
            intentForActions = new Intent(this,KnowledgeActivity.class);
            intentForActions.putExtra("lan",langueToPass);
            startActivity(intentForActions);
        } else if (id == R.id.nav_phone_number) {
            intentForActions = new Intent(Intent.ACTION_DIAL);
            intentForActions.setData(Uri.parse("tel:" + getString(R.string.my_phone_number)));
            startActivity(intentForActions);
        } else if (id == R.id.nav_email) {
            emailToSend = new String[] {getString(R.string.my_email)};
            intentForActions = new Intent(Intent.ACTION_SEND);
            intentForActions.setType("message/rfc822");
            intentForActions.putExtra(Intent.EXTRA_EMAIL, emailToSend );
            intentForActions.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
            Intent mail = Intent.createChooser(intentForActions, null);
            startActivity(mail);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //For bug fix on API 21
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //No call for super(). Bug on API Level > 11.
    }

    @Override
    protected void onResume() {
        super.onResume();
        uncheckMenuItems();

//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(comeFromAct){
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new EndFragment())
                    .commit();
            getSupportActionBar().setTitle(getString(R.string.title_end_toolbar));
        } else if  (!comeFromAct) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new StartFragment())
                    .commit();
            getSupportActionBar().setTitle(getString(R.string.frag_start));
        } else{
            return;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        comeFromAct = true;
    }

    private void uncheckMenuItems(){
        int size = navigationView.getMenu().size();
        for (int i = 0; i < size; i++) {
            navigationView.getMenu().getItem(i).setChecked(false);
        }
    }
}
