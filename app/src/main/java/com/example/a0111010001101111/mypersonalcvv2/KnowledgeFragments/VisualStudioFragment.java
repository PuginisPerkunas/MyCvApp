package com.example.a0111010001101111.mypersonalcvv2.KnowledgeFragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a0111010001101111.mypersonalcvv2.MainMethods;
import com.example.a0111010001101111.mypersonalcvv2.Models.DataStorage;
import com.example.a0111010001101111.mypersonalcvv2.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class VisualStudioFragment extends Fragment implements MainMethods {

    View view;
    Context context;
    DataStorage dataStorage;

    TextView title, subtitle, mainText;

    public VisualStudioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_visual_studio,container,false);

        init();
        setFactorys();
        setListeners();

        return view;
    }

    @Override
    public void init() {
        context = getContext();
        title = view.findViewById(R.id.title_visual_frag);
        subtitle = view.findViewById(R.id.sub_visual_frag);
        mainText = view.findViewById(R.id.main_text_visual_frag);
        dataStorage = new DataStorage(context);
    }

    @Override
    public void setListeners() {

    }

    @Override
    public void setFactorys() {
        title.setTypeface(dataStorage.getFontBold());
        subtitle.setTypeface(dataStorage.getFontRegular());
        mainText.setTypeface(dataStorage.getFontRegular());
    }
}
