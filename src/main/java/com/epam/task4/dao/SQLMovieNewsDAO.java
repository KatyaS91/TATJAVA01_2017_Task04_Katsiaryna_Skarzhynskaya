package com.epam.task4.dao;

import com.epam.task4.bean.MovieNews;
import com.epam.task4.bean.News;
import com.epam.task4.bean.NewsSet;
import com.epam.task4.dao.commection.pool.ConnectionPool;
import com.epam.task4.dao.commection.pool.ConnectionPoolException;

import java.sql.*;

/**
 * Created by Katsiaryna_Skarzhyns on 2/13/2017.
 */
public class SQLMovieNewsDAO implements MovieNewsDAO {

    private Connection con;
    private Connection takeCon() {
        try {
            ConnectionPool.getInstance().initPoolData();
            con = ConnectionPool.getInstance().takeConnection();
        } catch (ConnectionPoolException e) {
            System.out.println("ConnectionPool error");
        }
        return con;

    }

    public void putMovieNews(News news) throws DAOException {
        try {
            takeCon();
            String sql = "INSERT INTO movienews(title,description) VALUES(?,?)";
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

    public NewsSet selectAllMovieNews() throws DAOException {
        NewsSet set = new NewsSet();
        try {
            takeCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM movienews");
            while (rs.next()) {
                News news = new MovieNews();
                news.setTitle(rs.getString("title"));
                news.setDescription(rs.getString("description"));
                set.add(news);
            }
        } catch (SQLException e) {
            System.out.println("some error in findMovie");
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
            String sql = "SELECT * FROM movienews WHERE title ='" + title + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                News news = new MovieNews();
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
