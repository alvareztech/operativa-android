package com.danyalvarez.operationsresearch.classes;

import android.graphics.Bitmap;

/**
 * Created by daniel on 22/02/14.
 */
public class ResultItem {

    private String titleSection;

    private int idIcon;
    private String description;
    private double result;


    public ResultItem(String titleSection, int idIcon, String description, double result) {
        this.titleSection = titleSection;
        this.idIcon = idIcon;
        this.description = description;
        this.result = result;
    }

    public ResultItem(int idIcon, String description, double result) {
        this.titleSection = "";
        this.idIcon = idIcon;
        this.description = description;
        this.result = result;
    }

    public String getTitleSection() {
        return titleSection;
    }

    public void setTitleSection(String titleSection) {
        this.titleSection = titleSection;
    }

    public int getIdIcon() {
        return idIcon;
    }

    public void setIdIcon(int idIcon) {
        this.idIcon = idIcon;
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
