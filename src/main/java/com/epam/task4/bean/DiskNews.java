package com.epam.task4.bean;

/**
 * Created by Katsiaryna_Skarzhyns on 2/13/2017.
 */
public class DiskNews extends News {
    private String title;
    private String description;
    private String findParam;

    public DiskNews(){}

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

    @Override
    public String toString() {
        return "DiskNews{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", findParam='" + findParam + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DiskNews diskNews = (DiskNews) o;

        if (!title.equals(diskNews.title)) return false;
        if (!description.equals(diskNews.description)) return false;
        return findParam != null ? findParam.equals(diskNews.findParam) : diskNews.findParam == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (findParam != null ? findParam.hashCode() : 0);
        return result;
    }
}
