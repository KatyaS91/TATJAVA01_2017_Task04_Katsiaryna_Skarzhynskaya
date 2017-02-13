package com.epam.task4.controller;

import com.epam.task4.bean.News;
import com.epam.task4.service.DiskNewsService;
import com.epam.task4.service.MovieNewsService;
import com.epam.task4.service.ServiceException;
import com.epam.task4.service.ServiceFactory;

/**
 * Created by Katsiaryna_Skarzhyns on 2/13/2017.
 */
public class AddDiskNews implements Command {
    String response = null;

    public String execute(News news) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        DiskNewsService diskNewsService = serviceFactory.getDiskNewsService();
        try {
            diskNewsService.addNewDiskNews(news);
            response = "Sucsessful add";
        } catch (ServiceException e) {
            response = "Not sucs";
        }
        return response;
    }
}
