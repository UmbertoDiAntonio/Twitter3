package com.umberto.database;

import com.google.gson.annotations.Expose;
import com.umberto.Main;

import java.util.ArrayList;
import java.util.List;

public class UserData {

    @Expose
    private String  message;
    @Expose
    private String  user;
    @Expose
    private String  screen_name;
    @Expose
    public static String[] filterlist;


    public static void divideString(String str){
        filterlist=str.split(",");
    }

    public  String getMessage() {
        return message;
    }

    public  String getUser() {
        return user;
    }
    public static List<UserData> userList = new ArrayList<>();
    public  String getScreen_name() {
        return screen_name;
    }
    public static List<UserData> getUserDataList() {
        return userList;
    }
    public UserData(String user, String screen_name, String message) {
        this.user=user;
        this.screen_name=screen_name;
        this.message=message;
    }

    @Override
    public String toString() {
        return  "\bUser{" + "nome='" + user + '\'' + ", screen_name='" + screen_name + '\'' + ", messaggio='" + message;
    }
}
