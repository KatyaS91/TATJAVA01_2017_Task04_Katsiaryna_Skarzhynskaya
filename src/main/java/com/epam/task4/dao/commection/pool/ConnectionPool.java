package com.epam.task4.dao.commection.pool;

import java.sql.*;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class ConnectionPool {

    private BlockingQueue<Connection> connectionQueue;
    private BlockingQueue<Connection> givenAwayConQueue;

    private String driverName;
    private String url;
    private String user;
    private String password;
    private int poolsize;

    private final static ConnectionPool instance = new ConnectionPool();

    public static ConnectionPool getInstance() {
        return instance;
    }

    private ConnectionPool(){
        DBResourceManager dbResourceManager = DBResourceManager.getInstance();
        this.driverName = dbResourceManager.getValue(DBParameter.DB_DRIVER);
        this.url = dbResourceManager.getValue(DBParameter.DB_URL);
        this.user = dbResourceManager.getValue(DBParameter.DB_USER);
        this.password = dbResourceManager.getValue(DBParameter.DB_PASSWORD);

        try {
            this.poolsize = Integer.parseInt(dbResourceManager.getValue(DBParameter.DB_POOL_SIZE));
        } catch (NumberFormatException e){
            poolsize = 5;
        }
    }

    public void initPoolData() throws ConnectionPoolException {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName(driverName);
            givenAwayConQueue = new ArrayBlockingQueue<Connection>(poolsize);
            connectionQueue = new ArrayBlockingQueue<Connection>(poolsize);
            for (int i = 0; i < poolsize; i++){
                Connection connection = DriverManager.getConnection(url, user, password);
                connectionQueue.add(connection);
            }
        } catch (SQLException e){
            throw new ConnectionPoolException("SQLException in ConnectionPool", e);
        }catch (ClassNotFoundException e){
            throw new  ConnectionPoolException ("Cant find database driver class", e);
        }
    }

    public Connection takeConnection() throws ConnectionPoolException{
        Connection connection = null;
        try {
            connection = connectionQueue.take();
            givenAwayConQueue.add(connection);
        } catch (InterruptedException e){
            throw new ConnectionPoolException("Error connecting to the DB", e);
        }
        return connection;
    }

    public void closeConnection(Connection con, Statement st, ResultSet rs) {
        try {
            con.close();
        } catch (SQLException e){
            System.out.println("logger connection is not return to the pool");
        }
        try {
            rs.close();
        } catch (SQLException e){
            System.out.println("logger resultset is not closed");
        }
        try {
            st.close();
        } catch (SQLException e){
            System.out.println("logger statment is not closed");
        }
    }

    public void closeConnection(Connection con, Statement st){
        try {
            con.close();
        } catch (SQLException e){
            System.out.println("logger connection is not return to the pool");
        }
        try {
            st.close();
        } catch (SQLException e){
            System.out.println("logger statment is not closed");
        }
    }

}
