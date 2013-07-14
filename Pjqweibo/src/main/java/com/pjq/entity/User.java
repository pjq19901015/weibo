package com.pjq.entity;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: pjq
 * Date: 13-7-10
 * Time: 上午11:11
 * To change this template use File | Settings | File Templates.
 */
public class User  extends Object implements Serializable{
    public long id;
    public String name;
    public String profile_image_url;
    public Status status;

    public User() {
    }

    public User(long id, String name, String profile_image_url, Status status) {
        this.id = id;
        this.name = name;
        this.profile_image_url = profile_image_url;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
