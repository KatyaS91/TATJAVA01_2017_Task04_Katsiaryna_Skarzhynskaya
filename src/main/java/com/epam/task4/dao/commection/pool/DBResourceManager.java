package com.epam.task4.dao.commection.pool;

import java.util.ResourceBundle;

/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public class DBResourceManager {
    private final static DBResourceManager instance = new DBResourceManager();

    private ResourceBundle bundle = ResourceBundle.getBundle("_java.se._07._connectionpool.db");

    public static DBResourceManager getInstance(){
        return instance;
    }
    public String getValue(String key){
        return bundle.getString(key);
    }

}
