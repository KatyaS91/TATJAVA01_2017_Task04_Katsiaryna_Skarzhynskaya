package com.epam.task4.service;

/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final BookNewsService bookNewsService = new BookNewsServiceImpl();
/*    private final DiskNewsService diskNewsService = new DiskNewsServiceImpl();
    private final MovieNewsService movieNewsService = new MovieNewsServiceImpl();*/

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public BookNewsService getBookNewsService(){
        return bookNewsService;
    }
/*    public DiskNewsService getDiskNewsService(){ return diskNewsService; }
    public MovieNewsService getMovieNewsService(){
        return movieNewsService;
    }*/


}
