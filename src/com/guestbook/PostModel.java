package com.guestbook;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    private static Date getCurrentTimeStamp() {
        Date today = Calendar.getInstance().getTime();
        return today;
    }

    public static List<Post> getPosts() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = getConnection().createStatement().executeQuery("SELECT name, commentary, date FROM posts");

        ArrayList<Post> l = new ArrayList<Post>();

        while (resultSet.next()){
            String aName = resultSet.getString(1);
            String aCommentary = resultSet.getString(2);
            Date aDate = resultSet.getDate(3);

            Post post = new Post();
            post.setName(aName);
            post.setCommentary(aCommentary);
            post.setDate(aDate);
            l.add(post);
        }

        resultSet.close();
        getConnection().close();

        return l;
    }



    public static void addPosts(String name, String commentary) throws SQLException, ClassNotFoundException {
        String aName = name;
        String aCommentary = commentary;
        Date date = getCurrentTimeStamp();
        String query = "INSERT INTO posts (name, commentary, date) VALUES (" + aName + ", " + aCommentary + ", " + date + ")";
        getConnection().createStatement().executeUpdate(query);
        getConnection().close();
    }
}
