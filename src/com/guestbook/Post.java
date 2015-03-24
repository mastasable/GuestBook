package com.guestbook;
import java.util.Date;


/**
 * Created by admin on 22.03.2015.
 */
public class Post {
    public String name;
    public String commentary;
    public String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date date;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
