package com.epam.task4.service;

import com.epam.task4.bean.News;
import com.epam.task4.bean.NewsSet;

/**
 * Created by Katsiaryna_Skarzhyns on 2/13/2017.
 */
public interface DiskNewsService {
    void addNewDiskNews(News news) throws ServiceException;

    NewsSet findAllDiskNews() throws ServiceException;

    NewsSet findNewsByTitle(String title) throws ServiceException;
}
