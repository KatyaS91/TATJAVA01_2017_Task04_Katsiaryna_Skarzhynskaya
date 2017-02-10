package com.epam.task4.dao;

import com.epam.task4.bean.News;
import com.epam.task4.bean.NewsSet;

import java.sql.*;

/**
 * Created by Katsiaryna_Skarzhyns on 2/8/2017.
 */
public class SQLBookNewsDAO implements BookNewsDAO {

    public void putBookNews(News news) throws DAOException{
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/catalog", "root","admin");
            System.out.println("Соединение установлено");
            String sql = "INSERT INTO booknews(title,description) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,"New book");
            ps.setString(2,"Some description");
            ps.executeUpdate();

        } catch (ClassNotFoundException e){
                System.out.println("Соединение не установлено ClassNotFoundEx");
        } catch (SQLException e){
            System.out.println("Соединение не установлено SQLEx");
        }
        finally {
            try {
                if(con!=null){con.close();}
        } catch (SQLException e){
                System.out.println("Соединение не закрыто");
            }

         }
     }

    public NewsSet selectAllBookNews() throws DAOException{
        Connection con = null;
        NewsSet set = new NewsSet();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/catalog", "root","admin");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM booknews");
            while (rs.next()){
                News news = new News();
                news.setTitle(rs.getString("title"));
                news.setDescription(rs.getString("description"));
                set.add(news);
            }
        } catch (SQLException e){
            // log sql exception
        } catch (ClassNotFoundException e){
            // some log
        }
        return set;
    }

    public NewsSet findNewsByTitle(String title) throws DAOException{
        Connection con = null;
        NewsSet set = new NewsSet();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/catalog", "root","admin");
            Statement st = con.createStatement();
            String sql = "SELECT * FROM booknews WHERE title = " + "'" + title + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                News news = new News();
                news.setTitle(rs.getString("title"));
                news.setDescription(rs.getString("description"));
                set.add(news);
            }
        } catch (SQLException e){
            // some log
        } catch (ClassNotFoundException e){
            //somw log
        }

        return set;
    }

}