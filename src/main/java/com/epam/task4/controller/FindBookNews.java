package com.epam.task4.controller;

import com.epam.task4.bean.News;
import com.epam.task4.bean.NewsSet;
import com.epam.task4.service.BookNewsService;
import com.epam.task4.service.ServiceException;
import com.epam.task4.service.ServiceFactory;

/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public class FindBookNews implements Command{
    String response = null;

    public String execute(News news) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookNewsService bookNewsService = serviceFactory.getBookNewsService();
        try {
            NewsSet x = bookNewsService.findAllBookNews();
            response = x.toString();
        } catch (ServiceException e) {
            response = "no one news";
        }
        return response;
    }

}
