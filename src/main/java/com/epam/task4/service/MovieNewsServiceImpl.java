package com.epam.task4.service;

import com.epam.task4.bean.News;
import com.epam.task4.bean.NewsSet;
import com.epam.task4.dao.DAOException;
import com.epam.task4.dao.DAOFactory;
import com.epam.task4.dao.MovieNewsDAO;

/**
 * Created by Katsiaryna_Skarzhyns on 2/13/2017.
 */
public class MovieNewsServiceImpl implements MovieNewsService {
    public void addNewMovieNews(News news) throws ServiceException {
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            MovieNewsDAO movieNewsDAO = daoObjectFactory.getMovieNewsDAO();
            movieNewsDAO.putMovieNews(news);
        } catch (DAOException e) {
            System.out.println("Error service layer");
        }
    }

    public NewsSet findAllMovieNews() throws ServiceException {
        NewsSet x = null;
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            MovieNewsDAO movieNewsDAO = daoObjectFactory.getMovieNewsDAO();
            x = movieNewsDAO.selectAllMovieNews();
        } catch (DAOException e) {
            System.out.println("Error service layer");
        }
        return x;
    }

    public NewsSet findNewsByTitle(String title) throws ServiceException {
        NewsSet x = null;
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            MovieNewsDAO movieNewsDAO = daoObjectFactory.getMovieNewsDAO();
            x = movieNewsDAO.findNewsByTitle(title);
        } catch (DAOException e) {
            System.out.println("Error service layer");
        }
        return x;
    }
}
