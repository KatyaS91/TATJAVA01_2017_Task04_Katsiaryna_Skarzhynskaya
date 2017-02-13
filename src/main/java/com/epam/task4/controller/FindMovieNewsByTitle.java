package com.epam.task4.controller;

import com.epam.task4.bean.News;
import com.epam.task4.bean.NewsSet;
import com.epam.task4.service.MovieNewsService;
import com.epam.task4.service.ServiceException;
import com.epam.task4.service.ServiceFactory;

/**
 * Created by Katsiaryna_Skarzhyns on 2/13/2017.
 */
public class FindMovieNewsByTitle implements Command {
    String response = null;

    public String execute(News news) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MovieNewsService movieNewsService = serviceFactory.getMovieNewsService();
        try {
            NewsSet x = movieNewsService.findNewsByTitle(news.getFindParam());
            for (int i = 0; i < x.size(); i++) {
                response += x.getSet().get(i).toString();
            }
        } catch (ServiceException e) {
            response = "no such movie";
        }
        return response;
    }
}
