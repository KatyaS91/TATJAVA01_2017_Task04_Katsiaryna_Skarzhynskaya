package com.epam.task4.dao.commection.pool;

import java.util.ResourceBundle;

import static com.epam.task4.dao.commection.pool.DBParameter.DB_DRIVER;
import static com.epam.task4.dao.commection.pool.DBParameter.DB_URL;

/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 */
public class DBResourceManager {
    private final static DBResourceManager instance = new DBResourceManager();
    private ResourceBundle bundle = ResourceBundle.getBundle("config");


    public static DBResourceManager getInstance(){
        return instance;
    }

    public String getValue(String key){
        return bundle.getString(key);
    }
}


