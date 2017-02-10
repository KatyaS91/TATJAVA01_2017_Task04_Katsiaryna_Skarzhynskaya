package com.epam.task4.controller;

import com.epam.task4.bean.News;

/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public interface Command {
    String execute(News news);
}
