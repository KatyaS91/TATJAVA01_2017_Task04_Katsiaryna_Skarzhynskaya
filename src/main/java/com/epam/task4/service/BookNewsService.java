package com.epam.task4.service;

import com.epam.task4.bean.News;
import com.epam.task4.bean.NewsSet;

/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public interface BookNewsService {
    void addNewBookNews(News news) throws ServiceException;
    NewsSet findAllBookNews() throws ServiceException;
    NewsSet findNewsByTitle(String title) throws ServiceException;
}
