package com.epam.task4.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public class NewsSet {

    List<News> set = new ArrayList<News>();

    public List<News> getSet() {
        return set;
    }

    public void add(News news) {
        set.add(news);
    }

    public int size() {
        return set.size();
    }

    @Override
    public String toString() {
        return "NewsSet{" +
                "set=" + set +
                '}';
    }

}
