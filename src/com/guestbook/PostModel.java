package com.guestbook;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public static List<Post> getPosts() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = getConnection().createStatement().executeQuery("SELECT name, commentary, date FROM posts");

        ArrayList<Post> l = new ArrayList<Post>();

        while (resultSet.next()){
            String aName = resultSet.getString(1);
            String aCommentary = resultSet.getString(2);
            Date aDate = resultSet.getDate(3);

            Post post = new Post();
            post.getName(aName);
            post.getCommentary(aCommentary);
            post.getDate(aDate);
            l.add(post);
        }

        resultSet.close();
        getConnection().close();

        return l;
    }
}
