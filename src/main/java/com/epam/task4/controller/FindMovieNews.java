package com.epam.task4.controller;

import com.epam.task4.bean.News;
import com.epam.task4.bean.NewsSet;
import com.epam.task4.service.MovieNewsService;
import com.epam.task4.service.ServiceException;
import com.epam.task4.service.ServiceFactory;

/**
 * Created by Katsiaryna_Skarzhyns on 2/13/2017.
 */
public final class FindMovieNews implements Command {
    String response = "";

    public String execute(News news) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MovieNewsService movieNewsService = serviceFactory.getMovieNewsService();
        try {
            NewsSet x = movieNewsService.findAllMovieNews();
            for (int i = 0; i < x.size(); i++) {
                response += x.getSet().get(i).toString() + "\n";
            }
        } catch (ServiceException e) {
            response = "no one movie";
        }
        return response;
    }
}
