package com.epam.task4.service;

import com.epam.task4.bean.News;
import com.epam.task4.bean.NewsSet;
import com.epam.task4.dao.DAOException;
import com.epam.task4.dao.DAOFactory;
import com.epam.task4.dao.DiskNewsDAO;

/**
 * Created by Katsiaryna_Skarzhyns on 2/13/2017.
 */
public final class DiskNewsServiceImpl implements DiskNewsService {
    public void addNewDiskNews(News news) throws ServiceException {
        if (news.getTitle() != null && news.getDescription() != null) {
            try {
                DAOFactory daoObjectFactory = DAOFactory.getInstance();
                DiskNewsDAO diskNewsDAO = daoObjectFactory.getDiskNewsDAO();
                diskNewsDAO.putDiskNews(news);
            } catch (DAOException e) {
                System.out.println("Error service layer");
            }
        } else {
            System.out.println("Empty request");
        }
    }

    public NewsSet findAllDiskNews() throws ServiceException {
        NewsSet x = null;
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            DiskNewsDAO diskNewsDAO = daoObjectFactory.getDiskNewsDAO();
            x = diskNewsDAO.selectAllDiskNews();
        } catch (DAOException e) {
            System.out.println("Error service layer");
        }
        return x;
    }

    public NewsSet findNewsByTitle(String title) throws ServiceException {
        NewsSet x = null;
        if (title != null) {
            try {
                DAOFactory daoObjectFactory = DAOFactory.getInstance();
                DiskNewsDAO diskNewsDAO = daoObjectFactory.getDiskNewsDAO();
                x = diskNewsDAO.findNewsByTitle(title);
            } catch (DAOException e) {
                System.out.println("Error service layer");
            }
        } else {
            System.out.println("Empty request");
        }
        return x;
    }
}
