package com.danyalvarez.operationsresearch.classes;

import android.graphics.Bitmap;

/**
 * Created by daniel on 22/02/14.
 */
public class ResultItem {

    private String titleSection;

    private Bitmap icon;
    private String description;
    private double result;


    public ResultItem(String titleSection, Bitmap icon, String description, double result) {
        this.titleSection = titleSection;
        this.icon = icon;
        this.description = description;
        this.result = result;
    }

    public ResultItem(Bitmap icon, String description, double result) {
        this.titleSection = "";
        this.icon = icon;
        this.description = description;
        this.result = result;
    }


    public String getTitleSection() {
        return titleSection;
    }

    public void setTitleSection(String titleSection) {
        this.titleSection = titleSection;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
