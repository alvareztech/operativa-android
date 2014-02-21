package com.danyalvarez.operationsresearch.classes;

/**
 * Created by daniel on 20/02/14.
 */
public class Option {

    private String title;
    private String description;

    public Option(String title, String description) {
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
}
