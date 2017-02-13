package com.epam.task4.dao;

import com.epam.task4.bean.News;
import com.epam.task4.bean.NewsSet;

/**
 * Created by Katsiaryna_Skarzhyns on 2/13/2017.
 */
public interface MovieNewsDAO {
    void putMovieNews(News news) throws DAOException;

    NewsSet selectAllMovieNews() throws DAOException;

    NewsSet findNewsByTitle(String title) throws DAOException;
}
