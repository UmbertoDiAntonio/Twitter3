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
    static Vector<String> screenListExt = new Vector<>();
    @Expose
    static Vector<String> monthList = new Vector<>();
    @Expose
    static Vector<String> dayList = new Vector<>();
    @Expose
    static Vector<String> yearList = new Vector<>();

    public static Vector<String> getScreenListExt() {
        return screenListExt;
    }
    public static void createdAtdivide(String str) {
        String[] temp = str.split(" ");
        monthList.add(temp[1]);
        dayList.add(temp[2]);
        yearList.add(temp[5]);
    }

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

    public UserData(String screenName, String message, String createdAt) {
        this.screenName = screenName;
        this.message = message;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "\bUser{" + ", screen_name='" + screenName + '\'' + ", messaggio='" + message;
    }
}
