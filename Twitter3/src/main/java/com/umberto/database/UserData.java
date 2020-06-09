package com.umberto.database;

import com.google.gson.annotations.Expose;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class UserData {

    @Expose
    private String  message;
    @Expose
    private String  screen_name;
    @Expose
    public static String[] filterlist;

    public static Vector<String> messageList=new Vector<>();
    public static Vector<String> screenList=new Vector<>();
    public static void divideString(String str){
        filterlist=str.split(",");
    }

    public  String getMessage() {
        return message;
    }


    public static List<UserData> userList = new ArrayList<>();
    public  String getScreen_name() {
        return screen_name;
    }
    public static List<UserData> getUserDataList() {
        return userList;
    }
    public UserData(String screen_name, String message) {
        this.screen_name=screen_name;
        this.message=message;
    }

    @Override
    public String toString() {
        return  "\bUser{" + ", screen_name='" + screen_name + '\'' + ", messaggio='" + message;
    }
}
