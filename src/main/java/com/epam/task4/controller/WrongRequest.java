package com.epam.task4.controller;

import com.epam.task4.bean.News;

/**
 * Created by Katsiaryna_Skarzhyns on 2/13/2017.
 */
public final class WrongRequest implements Command {
    public String execute(News news) {
        return "WrongRequest";
    }
}
