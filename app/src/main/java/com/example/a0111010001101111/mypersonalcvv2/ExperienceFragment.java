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

import com.example.a0111010001101111.mypersonalcvv2.Adapters.ExperienceAdapter;
import com.example.a0111010001101111.mypersonalcvv2.Models.DataStorage;
import com.example.a0111010001101111.mypersonalcvv2.Models.ExperienceItemObjet;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExperienceFragment extends Fragment {

    View view;
    TextView fragmentTitle, fragmentExplain;

    private RecyclerView recyclerView;
    private ExperienceAdapter experienceAdapter;
    private LinearLayoutManager layoutManager;
    private Context context;
    private DataStorage dataStorage;


    public ExperienceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_experience,container,false);
        init();
        bindList();
        setFactorys();

        return view;
    }

    private void init(){
        context = getContext();
        dataStorage = new DataStorage(context);
        fragmentTitle = (TextView) view.findViewById(R.id.experience_sec_text);
        fragmentExplain = (TextView) view.findViewById(R.id.experience_sec_explain);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_experience);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setFactorys(){
        fragmentTitle.setTypeface(dataStorage.getFontBold());
        fragmentExplain.setTypeface(dataStorage.getFontRegular());
    }

    private void bindList(){
        List<ExperienceItemObjet> post = new ArrayList<ExperienceItemObjet>();
        post = dataStorage.getExperienceList();

        experienceAdapter = new ExperienceAdapter(context,post);
        recyclerView.setAdapter(experienceAdapter);
    }


}
