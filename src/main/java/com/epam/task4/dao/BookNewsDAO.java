package com.epam.task4.dao;

import com.epam.task4.bean.News;
import com.epam.task4.bean.NewsSet;

/**
 * Created by Katsiaryna_Skarzhyns on 2/7/2017.
 */
public interface BookNewsDAO {
    void putBookNews(News news) throws DAOException;
    NewsSet selectAllBookNews() throws DAOException;
    NewsSet findNewsByTitle(String title) throws DAOException;
}
