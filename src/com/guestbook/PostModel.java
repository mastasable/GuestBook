package com.guestbook;

import java.beans.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 22.03.2015.
 */
public class PostModel {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/guestbook", "valiv", "valiv");
    }

    private static java.sql.Timestamp getCurrentTimeStamp() {
        Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }

    public static List<Post> getPosts() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = getConnection().createStatement().executeQuery("SELECT name, commentary, date, url FROM posts");

        ArrayList<Post> l = new ArrayList<Post>();

        while (resultSet.next()){
            String aName = resultSet.getString(1);
            String aCommentary = resultSet.getString(2);
            Date aDate = resultSet.getDate(3);
            String url = resultSet.getString(4);

            Post post = new Post();
            post.setName(aName);
            post.setCommentary(aCommentary);
            post.setDate(aDate);
            post.setUrl(url);
            l.add(post);
        }

        resultSet.close();
        getConnection().close();

        return l;
    }



    public static void addPosts(String name, String commentary, String url) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO posts" +
                "(name, commentary, date, url)VALUES" +
                "(?, ?, ?, ?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, commentary);
        preparedStatement.setTimestamp(3, getCurrentTimeStamp());
        preparedStatement.setString(4, url);
        preparedStatement.executeUpdate();
        getConnection().close();
    }
}
