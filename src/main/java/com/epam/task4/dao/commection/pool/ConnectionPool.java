/*
package com.epam.task4.com.epam.task4.dao.commection.pool;

import javax.sql.PooledConnection;
import java.sql.*;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

*/
/**
 * Created by Katsiaryna_Skarzhyns on 2/9/2017.
 *//*

public final class ConnectionPool {
    private BlockingQueue<Connection> connectionQueue;
    private BlockingQueue<Connection> givenAwayConQueue;

    private String driverName;
    private String url;
    private String user;
    private String password;
    private int poolsize;

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

    public void initPoolData() throws ConnectionPoolException{
        Locale.setDefault(Locale.ENGLISH);

        try {
            Class.forName(driverName);
            givenAwayConQueue = new ArrayBlockingQueue<Connection>(poolsize);
            connectionQueue = new ArrayBlockingQueue<Connection>(poolsize);
            for (int i = 0; i < poolsize; i++){
                Connection connection = DriverManager.getConnection(url, user, password);
*/
/*                PooledConnection pooledConnection = new PooledConnection(connection);
                connectionQueue.add(pooledConnection);*//*


            }
        } catch (SQLException e){
            throw new ConnectionPoolException("SQLException in ConnectionPool", e);
        }catch (ClassNotFoundException e){
            throw new  ConnectionPoolException ("Cant find database driver class", e);
        }
    }

    public void dispose(){
        clearConnectionQueue();
    }

    private void clearConnectionQueue(){
        try {
        closeConnectionQueue(givenAwayConQueue);
        closeConnectionQueue(connectionQueue);
    } catch (SQLException e){
        // logger
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

    public void closeConnectionQueue(Connection con, Statement st, ResultSet rs){
        try {
            con.close();
        } catch (SQLException e){
            // logger connection is not return to the pool
        }
        try {
            rs.close();
        } catch (SQLException e){
            // logger resultset is not closed
        }
        try {
            st.close();
        } catch (SQLException e){
            // logger statment is not closed
        }
    }

    public void closeConnection(Connection con, Statement st){
        try {
            con.close();
        } catch (SQLException e){
            //logger connection is not return to the pool
        }
        try {
            st.close();
        } catch (SQLException e){
            // logger statment is not closed
        }
    }

    private void closeConnectionsQueue(BlockingQueue<Connection> queue) throws SQLException{
        Connection connection;
        while ((connection = queue.poll()) != null) {
            if (!connection.getAutoCommit()){
                connection.commit();
            }
            ((PolledConnection) connection).reallyClose();
        }
    }
    class PolledConnection {
        private Connection connection;
        public void PooledConnection(Connection c) throws SQLException{
            this.connection = c;
            this.connection.setAutoCommit(true);
        }

        public void reallyClose() throws SQLException{
            connection.close();
        }

        public void clearWarnings() throws SQLException{
            connection.clearWarnings();
        }

        public void close() throws SQLException{
            if (connection.isClosed()){
                throw new SQLException("Attempting to close closed connection");
            }
            if(connection.isReadOnly()){
                connection.setReadOnly(false);
            }
            if(!givenAwayConQueue.remove(this)){
                throw new SQLException("Error deleting connection from the given away connect pool");
            }
            if (!connectionQueue.offer(connection)){
                throw new SQLException("Error allocating connection in the pool");
            }
        }

        public void commit() throws SQLException{
            connection.commit();
        }
    }
}
*/
