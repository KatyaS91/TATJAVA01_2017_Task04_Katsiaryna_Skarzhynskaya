package com.epam.task4.dao;

import com.epam.task4.bean.News;
import com.epam.task4.bean.NewsSet;
import com.epam.task4.dao.commection.pool.ConnectionPool;
import com.epam.task4.dao.commection.pool.ConnectionPoolException;

import java.sql.*;

/**
 * Created by Katsiaryna_Skarzhyns on 2/8/2017.
 */
public class SQLBookNewsDAO implements BookNewsDAO {
    private Connection con;

    private Connection takeCon() {
        try {
            ConnectionPool.getInstance().initPoolData();
            con = ConnectionPool.getInstance().takeConnection();
        } catch (ConnectionPoolException e) {
            //
        }
        return con;

    }

    public void putBookNews(News news) throws DAOException {
        try {
            takeCon();
            String sql = "INSERT INTO booknews(title,description) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Соединение не установлено SQLEx");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Соединение не закрыто");
            }

        }
    }

    public NewsSet selectAllBookNews() throws DAOException {
        NewsSet set = new NewsSet();
        try {
            takeCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM booknews");
            while (rs.next()) {
                News news = new News();
                news.setTitle(rs.getString("title"));
                news.setDescription(rs.getString("description"));
                set.add(news);
            }
        } catch (SQLException e) {
            // log sql exception
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Соединение не закрыто");
            }
        }
        return set;

    }

    public NewsSet findNewsByTitle(String title) throws DAOException {
        NewsSet set = new NewsSet();
        try {
            takeCon();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM booknews WHERE title =' " + title + " ' ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                News news = new News();
                news.setTitle(rs.getString("title"));
                news.setDescription(rs.getString("description"));
                set.add(news);
            }
        } catch (SQLException e) {
            System.out.println("error");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Соединение не закрыто");
            }
        }
        return set;

    }
}