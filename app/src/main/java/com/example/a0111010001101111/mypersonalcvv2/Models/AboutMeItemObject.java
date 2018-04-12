package com.example.a0111010001101111.mypersonalcvv2.Models;

/**
 * Created by 0111010001101111 on 4/5/2018.
 */

public class AboutMeItemObject {

    private int id;
    private String title;
    private String sectionText;

    public AboutMeItemObject(int id, String title, String sectionText) {
        this.id = id;
        this.title = title;
        this.sectionText = sectionText;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSectionText() {
        return sectionText;
    }
}
