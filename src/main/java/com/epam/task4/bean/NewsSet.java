package com.epam.task4.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public class NewsSet {

    List<News> Set = new ArrayList<News>();

    public void add(News news){
        Set.add(news);
    }

    @Override
    public String toString() {
        return "NewsSet{" +
                "Set=" + Set +
                '}';
    }
}
