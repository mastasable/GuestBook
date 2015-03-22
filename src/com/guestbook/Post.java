package com.guestbook;
import java.util.Date;


/**
 * Created by admin on 22.03.2015.
 */
public class Post {
    String name;
    String commentary;
    Date date;

    public void setName(String name) {
        this.name = name;
    }

    public String getName(String name) {
        return name;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getCommentary(String commentary) {
        return commentary;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate(Date date) {
        return date;
    }
}
