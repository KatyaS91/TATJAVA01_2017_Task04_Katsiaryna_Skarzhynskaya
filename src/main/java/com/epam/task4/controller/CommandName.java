package com.epam.task4.controller;

/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public enum CommandName {
    ADD_BOOK_NEWS("Add book news"),
    FIND_BOOK_NEWS("Find book news"),
    FIND_BOOK_NEWS_BY_TITLE("Find book news by title"),
    ADD_MOVIE_NEWS("Add movie news"),
    FIND_MOVIE_NEWS("Find movie news"),
    FIND_MOVIE_NEWS_BY_TITLE("Find movie news by title"),
    ADD_DISK_NEWS("Add disk news"),
    FIND_DISK_NEWS("Find disk news"),
    FIND_DISK_NEWS_BY_TITLE("Find disk news by title"),
    WRONG_REQUEST("");

    private String name;

    CommandName(String name){
        this.name = name;
    }

}
