package com.epam.task4.view;

import com.epam.task4.bean.BookNews;
import com.epam.task4.bean.DiskNews;
import com.epam.task4.bean.News;
import com.epam.task4.controller.Controller;

import java.awt.print.Book;


/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public class Starter {
    public static void main(String[] args){

        News bookNews = new BookNews();
        bookNews.setFindParam("Ivanhoe");
        bookNews.setTitle("Ivanhoe");
        bookNews.setDescription("Some description of the book");

        Controller controller = new Controller();
        //System.out.println(controller.executeTask("FIND_BOOK_NEWS", bookNews));
        //System.out.println(controller.executeTask("ADD_BOOK_NEWS", bookNews));
        News diskNews = new DiskNews();
        diskNews.setTitle("Traviata");
        diskNews.setDescription("Some description");
        diskNews.setFindParam("Rigoletto");
        //System.out.println(controller.executeTask("FIND_DISK_NEWS_BY_TITLE", diskNews));


    }
}
