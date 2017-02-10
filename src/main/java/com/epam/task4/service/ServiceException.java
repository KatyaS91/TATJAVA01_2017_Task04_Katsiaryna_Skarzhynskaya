package com.epam.task4.service;

/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public class ServiceException extends Exception {
    private static final long serialUID = 1L;

    public ServiceException(){
        super();
    }
    public ServiceException(String message){
        super(message);
    }
    public ServiceException(Exception e){
        super(e);
    }
    public ServiceException(String message, Exception e){
        super(message, e);
    }

}
