package com.epam.task4.controller;

import com.epam.task4.bean.News;
import com.epam.task4.service.BookNewsService;
import com.epam.task4.service.ServiceException;
import com.epam.task4.service.ServiceFactory;


/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public final class AddBookNews implements Command {
    String response = null;
    public String execute(News news){
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookNewsService bookNewsService = serviceFactory.getBookNewsService();
        try {
            bookNewsService.addNewBookNews(news);
            response = "Sucsessful add";
        } catch (ServiceException e){
            response = "Not sucs";
        }
        return response;
    }
}
