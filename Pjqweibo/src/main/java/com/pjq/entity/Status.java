package com.pjq.entity;

/**
 * Created with IntelliJ IDEA.
 * User: pjq
 * Date: 13-7-10
 * Time: 上午11:04
 * To change this template use File | Settings | File Templates.
 */
public class Status {

    public String created_at;
    public long id;
    public String text;
    public String source;
    public User user;
    public int  reposts_count;
    public int  comments_count;
    public String original_pic;

    public Status() {
    }

    public Status(String created_at, long id, String text, String source, User user,
                  int reposts_count, int comments_count, String original_pic) {

        this.created_at = created_at;
        this.id = id;
        this.text = text;
        this.source = source;
        this.user = user;
        this.reposts_count = reposts_count;
        this.comments_count = comments_count;
        this.original_pic = original_pic;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getReposts_count() {
        return reposts_count;
    }

    public void setReposts_count(int reposts_count) {
        this.reposts_count = reposts_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public String getOriginal_pic() {
        return original_pic;
    }

    public void setOriginal_pic(String original_pic) {
        this.original_pic = original_pic;
    }
}
