package com.epam.task4.dao;

/**
 * Created by Katsiaryna_Skarzhyns on 2/8/2017.
 */
public class DAOException extends Exception {
    private static final long serialVersionUID = 1L;

    public DAOException(){
        super();
    }
    public DAOException(String message){
        super(message);
    }
    public DAOException(Exception e){
        super(e);
    }
    public DAOException(String message, Exception e){
        super(message, e);
    }

}
