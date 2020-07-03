package com.umberto;

import com.umberto.database.UserData;

import java.time.Month;
import java.util.List;
import java.util.Objects;


public class OutputGenerator {

    /**
     * @deprecated
     */
    @Deprecated
    OutputGenerator(){

    }

    private static boolean conditionAutText(UserData user,String author,String text){
        return (user.getScreenName().equals(author) && user.getMessage().contains(Objects.requireNonNull(text)));
    }

    public static String outputPost(List<UserData> obj) {
        return Utils.saveData(obj);
    }

    public static Object outputPost(List<UserData> obj, String author) {
        UserData.getUserDataSubList().clear();
        for (UserData user : obj
        ) {
            if (user.getScreenName().equals(author)) {
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.saveData(UserData.getUserDataSubList());
    }

    public static Object outputPost(List<UserData> obj, String author, String text) {
        UserData.getUserDataSubList().clear();
        for (UserData user : obj
        ) {
            if ((author==null && user.getMessage().contains(text))||
                    (conditionAutText(user,author,text))) {
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.saveData(UserData.getUserDataSubList());
    }
    public static Object outputPost(List<UserData> obj, String author, String text,int year) {
        UserData.getUserDataSubList().clear();
        for (UserData user : obj
        ) {
            if (((author==null && text==null && Integer.parseInt(user.getYear())==year)||
                    author==null && user.getMessage().contains(Objects.requireNonNull(text))&&Integer.parseInt(user.getYear())==year)||
                    (conditionAutText(user,author,text) && Integer.parseInt(user.getYear())==year)
            ) {
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.saveData(UserData.getUserDataSubList());
    }
    public static Object outputPost(List<UserData> obj, String author, String text, int year, Month month) {
        UserData.getUserDataSubList().clear();
        for (UserData user : obj
        ) {
            if ((author==null && text==null && Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month))||
                    (author==null && user.getMessage().contains(Objects.requireNonNull(text))&&Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month))||
                    (conditionAutText(user,author,text) && Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month))
            ) {
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.saveData(UserData.getUserDataSubList());
    }
    public static Object outputPost(List<UserData> obj, String author, String text, int year, Month month,int day) {
        UserData.getUserDataSubList().clear();
        for (UserData user : obj
        ) {
            if ((author==null && text==null && Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month) && Integer.parseInt(user.getDay())==day)||
                    (author==null && user.getMessage().contains(Objects.requireNonNull(text))&&Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month) && Integer.parseInt(user.getDay())==day)||
                    (conditionAutText(user,author,text) && Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month)&& Integer.parseInt(user.getDay())==day)
            ) {
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.saveData(UserData.getUserDataSubList());
    }
    public static Object outputPost(List<UserData> obj, String author, String text, int year, Month month,int day,CharSequence hour) {
        UserData.getUserDataSubList().clear();
        for (UserData user : obj
        ) {
            if ((author==null && text==null && Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month) && Integer.parseInt(user.getDay())==day && user.getHour().contains(hour))||
                    (author==null && user.getMessage().contains(Objects.requireNonNull(text))&&Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month) && Integer.parseInt(user.getDay())==day && user.getHour().contains(hour))||
                    (conditionAutText(user,author,text) && Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month)&& Integer.parseInt(user.getDay())==day && user.getHour().contains(hour))
            ) {
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.saveData(UserData.getUserDataSubList());
    }

}
