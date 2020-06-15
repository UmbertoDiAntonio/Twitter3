package com.umberto.database;

import com.google.gson.annotations.Expose;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class UserData {

    @Expose
     String message;
    @Expose
     String screenName;
    @Expose
     String createdAt;
    @Expose
    String month;
    @Expose
    String day;
    @Expose
    String hour;
    @Expose
    String year;

    public static Vector<String> getScreenList() {
        return screenList;
    }

    @Expose
    static Vector<String> screenList=new Vector<>();


    public String getMessage() {
        return message;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    static List<UserData> userDataList = new ArrayList<>();
    static List<UserData> userDataSubList = new ArrayList<>();
    public String getScreenName() {
        return screenName;
    }
    public static List<UserData> getUserDataSubList() {
        return userDataSubList;
    }
    public static List<UserData> getUserDataList() {
        return userDataList;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }


    public UserData(String screenName, String message, String createdAt, String month, String day, String hour, String year) {
        this.screenName = screenName;
        this.message = message;
        this.createdAt = createdAt;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.year = year;

    }

    @Override
    public String toString() {
        return "\bUser{" + ", screen_name='" + screenName + '\'' + ", messaggio='" + message;
    }
}
