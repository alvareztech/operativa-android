package com.danyalvarez.operationsresearch.classes;

public class Option {

    private String titleSection;

    private String title;
    private String description;

    public Option(String title, String description) {
        this.titleSection = "";
        this.title = title;
        this.description = description;
    }

    public Option(String titleSection, String title, String description) {
        this.titleSection = titleSection;
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitleSection() {
        return titleSection;
    }

    public void setTitleSection(String titleSection) {
        this.titleSection = titleSection;
    }
}
