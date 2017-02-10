package com.epam.task4.dao.commection.pool;

/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public class ConnectionPoolException extends Exception{
    private static final long serialVersionUID = 1L;

    public ConnectionPoolException(String message, Exception e){
        super(message,e);
    }

}
