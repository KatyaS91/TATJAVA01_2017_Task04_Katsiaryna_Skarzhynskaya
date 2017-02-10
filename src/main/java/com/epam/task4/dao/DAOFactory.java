package com.epam.task4.dao;

/**
 * Created by Katsiaryna_Skarzhyns on 2/8/2017.
 */
public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final BookNewsDAO sqlBookNewsImpl = new SQLBookNewsDAO();
   // private final DiskNewsDAO sqlDiskNewsImpl = new SQLDiskNewsDAO();
   // private final MovieNewsDAO sqlMovieNewsImpl = new SQLMovieNewsDAO();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public BookNewsDAO getBookNewsDAO(){
        return sqlBookNewsImpl;
    }

/*    public DiskNewsDAO getDiskNewsDAO(){
        return sqlDiskNewsImpl;
    }

    public MovieNewsDAO getMovieNewsDAO(){
        return sqlMovieNewsImpl;
    }
}*/

}
