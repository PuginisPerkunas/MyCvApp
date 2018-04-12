package com.example.a0111010001101111.mypersonalcvv2.Models;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;

import com.example.a0111010001101111.mypersonalcvv2.Activities.MainActivity;
import com.example.a0111010001101111.mypersonalcvv2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 0111010001101111 on 4/5/2018.
 */

public class DataStorage {

    private List<AboutMeItemObject> aboutMeList;
    private List<ExperienceItemObjet> experienceList;
    private Typeface fontBold, fontRegular;
    private Context context;
    private Resources resources = MainActivity.resources;
    public DataStorage(Context context) {
        this.context = context;
    }

    public List<AboutMeItemObject> getAboutMeList() {



        aboutMeList = new ArrayList<AboutMeItemObject>();
        aboutMeList.add(new AboutMeItemObject(1, resources.getString(R.string.about_me_item_one_title),
                resources.getString(R.string.about_me_item_one_text)));
        aboutMeList.add(new AboutMeItemObject(2,resources.getString(R.string.about_me_item_two_title),
                resources.getString(R.string.about_me_item_two_text)));
        aboutMeList.add(new AboutMeItemObject(3,context.getString(R.string.about_me_item_three_title),
                context.getString(R.string.about_me_item_three_text)));
        aboutMeList.add(new AboutMeItemObject(4,context.getString(R.string.about_me_item_four_title),
                context.getString(R.string.about_me_item_four_text)));
        aboutMeList.add(new AboutMeItemObject(5,context.getString(R.string.about_me_item_five_title),
                context.getString(R.string.about_me_item_five_text)));
        aboutMeList.add(new AboutMeItemObject(6,context.getString(R.string.about_me_item_six_title),
                context.getString(R.string.about_me_item_six_text)));

        return aboutMeList;
    }

    public List<ExperienceItemObjet> getExperienceList() {
        experienceList = new ArrayList<ExperienceItemObjet>();
        experienceList.add(new ExperienceItemObjet(1,context.getString(R.string.experience_title_one),
                context.getString(R.string.experience_explain_one), R.drawable.test_image_second));
        experienceList.add(new ExperienceItemObjet(2,context.getString(R.string.experience_title_two),
                context.getString(R.string.experience_explain_two), R.drawable.test_image_second));
        experienceList.add(new ExperienceItemObjet(3,context.getString(R.string.experience_title_three),
                context.getString(R.string.experience_explain_three), R.drawable.test_image));
        experienceList.add(new ExperienceItemObjet(4,context.getString(R.string.experience_title_four),
                context.getString(R.string.experience_explain_four), R.drawable.test_image));

        return experienceList;
    }

    public Typeface getFontBold() {
        fontBold = Typeface.createFromAsset(context.getAssets(), context.getString(R.string.font_name_qucksand_bold));
        return fontBold;
    }

    public Typeface getFontRegular() {
        fontRegular = Typeface.createFromAsset(context.getAssets(), context.getString(R.string.font_name_qucksand_reg));
        return fontRegular;
    }
}
