package com.epam.task4.controller;

import com.epam.task4.bean.News;
import com.epam.task4.service.MovieNewsService;
import com.epam.task4.service.ServiceException;
import com.epam.task4.service.ServiceFactory;

/**
 * Created by Katsiaryna_Skarzhyns on 2/13/2017.
 */
public final class AddMovieNews implements Command {
    String response = null;

    public String execute(News news) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MovieNewsService movieNewsService = serviceFactory.getMovieNewsService();
        try {
            movieNewsService.addNewMovieNews(news);
            response = "Sucsessful add";
        } catch (ServiceException e) {
            response = "Not sucs";
        }
        return response;
    }
}
