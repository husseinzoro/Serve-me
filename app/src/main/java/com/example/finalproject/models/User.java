package com.example.finalproject.models;
import java.io.Serializable;

public class User implements Serializable {
    String name ;
    int url ;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    String phone ;
    String from;
    String to;



    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    public User(String name , int url, String phone) {
        this.name = name;
        this.url = url ;
        this.phone = phone ;
    }
    public User(){ this.name = "" ;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
