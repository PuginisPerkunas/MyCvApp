package com.example.a0111010001101111.mypersonalcvv2;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a0111010001101111.mypersonalcvv2.Adapters.AboutMeAdapter;
import com.example.a0111010001101111.mypersonalcvv2.Models.AboutMeItemObject;
import com.example.a0111010001101111.mypersonalcvv2.Models.DataStorage;

import java.util.ArrayList;
import java.util.List;




/**
 * A simple {@link Fragment} subclass.
 */
public class AboutMeFragment extends Fragment {

    View view;
    TextView fragmentTitle, fragmentExplain;

    private RecyclerView recyclerView;
    private AboutMeAdapter aboutMeAdapter;
    private LinearLayoutManager layoutManager;
    private Context context;
    private DataStorage dataStorage;



    public AboutMeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_about_me,container,false);
        init();
        bindList();
        setFactorys();


        return view;
    }

    private void init(){
        context = getContext();
        dataStorage = new DataStorage(context);
        fragmentTitle = (TextView) view.findViewById(R.id.about_me_sec_text);
        fragmentExplain = (TextView) view.findViewById(R.id.about_me_sec_explain);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_about_me);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

    }

    private void setFactorys(){
        fragmentTitle.setTypeface(dataStorage.getFontBold());
        fragmentExplain.setTypeface(dataStorage.getFontRegular());
    }

    private void bindList(){
        List<AboutMeItemObject> post = new ArrayList<AboutMeItemObject>();
        post = dataStorage.getAboutMeList();

        aboutMeAdapter = new AboutMeAdapter(context,post);
        recyclerView.setAdapter(aboutMeAdapter);
    }

}
