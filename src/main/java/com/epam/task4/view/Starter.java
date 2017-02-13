package com.epam.task4.view;

import com.epam.task4.bean.BookNews;
import com.epam.task4.bean.DiskNews;
import com.epam.task4.bean.MovieNews;
import com.epam.task4.bean.News;
import com.epam.task4.controller.Controller;


/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public class Starter {
    public static void main(String[] args){

        Controller controller = new Controller();

        News bookNews = new BookNews();
        bookNews.setTitle("Ivanhoe");
        bookNews.setDescription("Some description of the book");
        bookNews.setFindParam("Bible");
        System.out.println("All book news: " + "\n" + controller.executeTask("FIND_BOOK_NEWS", bookNews));
        //System.out.println(controller.executeTask("ADD_BOOK_NEWS", bookNews));
        System.out.println("All books with title " + bookNews.getFindParam() + ": " + "\n" + controller.executeTask("FIND_BOOK_NEWS_BY_TITLE", bookNews));

        News diskNews = new DiskNews();
        diskNews.setTitle("Traviata");
        diskNews.setDescription("Some description");
        diskNews.setFindParam("Rigoletto");
        System.out.println("All disk with title " + diskNews.getFindParam() + ": " + "\n" + controller.executeTask("FIND_DISK_NEWS_BY_TITLE", diskNews));
        System.out.println("All disk news: " + "\n" + controller.executeTask("FIND_DISK_NEWS", diskNews));
        //System.out.println(controller.executeTask("ADD_DISK_NEWS", diskNews));

        News movieNews = new MovieNews();
        movieNews.setTitle("Insomnia");
        movieNews.setDescription("Some description");
        movieNews.setFindParam("Titanik");
        System.out.println("All movies with title " + movieNews.getFindParam() + ": " + "\n" + controller.executeTask("FIND_MOVIE_NEWS_BY_TITLE", movieNews));
        System.out.println("All movie news: " + "\n" + controller.executeTask("FIND_MOVIE_NEWS", movieNews));
        //System.out.println(controller.executeTask("ADD_MOVIE_NEWS", movieNews));


    }
}
