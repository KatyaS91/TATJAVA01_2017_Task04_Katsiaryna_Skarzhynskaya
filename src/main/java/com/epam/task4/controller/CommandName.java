package com.epam.task4.controller;

/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public enum CommandName {
    ADD_BOOK_NEWS("Add book news"),
    FIND_BOOK_NEWS("Find book news"),
    FIND_BOOK_NEWS_BY_TITLE("Find book news by title"),
    WRONG_REQUEST("");

    private String name;

    CommandName(String name){
        this.name = name;
    }

}
