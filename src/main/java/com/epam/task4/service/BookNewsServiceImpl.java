package com.epam.task4.service;

import com.epam.task4.bean.News;
import com.epam.task4.bean.NewsSet;
import com.epam.task4.dao.BookNewsDAO;
import com.epam.task4.dao.DAOException;
import com.epam.task4.dao.DAOFactory;

/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public class BookNewsServiceImpl implements BookNewsService {
    public void addNewBookNews(News news) throws ServiceException{
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            BookNewsDAO bookNewsDAO = daoObjectFactory.getBookNewsDAO();
            bookNewsDAO.putBookNews(news);
        } catch (DAOException e){
            // some log
        }
    }

    public NewsSet findAllBookNews() throws ServiceException{
        NewsSet x = null;
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            BookNewsDAO bookNewsDAO = daoObjectFactory.getBookNewsDAO();
            x = bookNewsDAO.selectAllBookNews();
        } catch (DAOException e){
            // some log
        }
        return x;
    }

    public NewsSet findNewsByTitle(String title) throws ServiceException{
        NewsSet x = null;
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            BookNewsDAO bookNewsDAO = daoObjectFactory.getBookNewsDAO();
            x = bookNewsDAO.findNewsByTitle(title);
        } catch (DAOException e){
            // some log
        }
        return x;
    }
}
