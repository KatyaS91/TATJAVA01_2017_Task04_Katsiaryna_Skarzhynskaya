package com.epam.task4.bean;

/**
 * Created by Katsiaryna_Skarzhyns on 2/8/2017.
 */
public class News {

    private String title;
    private String description;
    private String findParam;

    public String getFindParam() {
        return findParam;
    }

    public void setFindParam(String findParam) {
        this.findParam = findParam;
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
