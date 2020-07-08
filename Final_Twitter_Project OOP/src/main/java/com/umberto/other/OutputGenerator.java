package com.umberto.other;

import com.umberto.database.UserData;
import com.umberto.other.Utils;

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
        return "Sono Presenti:"+ Utils.getnMessage()+" Elementi\n\n"+ Utils.saveAsJson(obj);
    }

    public static Object outputPost(List<UserData> obj, String author) {
        UserData.getUserDataSubList().clear();
        int temp=0;
        for (UserData user : obj
        ) {
            if (user.getScreenName().equals(author))
            {temp++;
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.notNullReturn(UserData.getUserDataSubList(),temp);
    }

    public static Object outputPost(List<UserData> obj, String author, String text) {
        UserData.getUserDataSubList().clear();
        int temp=0;
        for (UserData user : obj
        ) {
            if ((author==null && user.getMessage().contains(text))||
                    (conditionAutText(user,author,text)))
            {temp++;
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.notNullReturn(UserData.getUserDataSubList(),temp);
    }
    public static Object outputPost(List<UserData> obj, String author, String text,int year) {
        UserData.getUserDataSubList().clear();
        int temp=0;
        for (UserData user : obj
        ) {
            if (((author==null && text==null && Integer.parseInt(user.getYear())==year)||
                    author==null && user.getMessage().contains(Objects.requireNonNull(text))&&Integer.parseInt(user.getYear())==year)||
                    (conditionAutText(user,author,text) && Integer.parseInt(user.getYear())==year)
            ) {temp++;
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.notNullReturn(UserData.getUserDataSubList(),temp);
    }
    public static Object outputPost(List<UserData> obj, String author, String text, int year, Month month) {
        UserData.getUserDataSubList().clear();
        int temp=0;
        for (UserData user : obj
        ) {
            if ((author==null && text==null && Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month))||
                    (author==null && user.getMessage().contains(Objects.requireNonNull(text))&&Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month))||
                    (conditionAutText(user,author,text) && Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month))
            ) {temp++;
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.notNullReturn(UserData.getUserDataSubList(),temp);
    }
    public static Object outputPost(List<UserData> obj, String author, String text, int year, Month month,int day) {
        UserData.getUserDataSubList().clear();
        int temp=0;
        for (UserData user : obj
        ) {
            if ((author==null && text==null && Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month) && Integer.parseInt(user.getDay())==day)||
                    (author==null && user.getMessage().contains(Objects.requireNonNull(text))&&Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month) && Integer.parseInt(user.getDay())==day)||
                    (conditionAutText(user,author,text) && Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month)&& Integer.parseInt(user.getDay())==day)
            ) {temp++;
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.notNullReturn(UserData.getUserDataSubList(),temp);
    }
    public static Object outputPost(List<UserData> obj, String author, String text, int year, Month month,int day,int hour) {
        UserData.getUserDataSubList().clear();
        int temp=0;

        for (UserData user : obj

        ) {
            String[] hours=Utils.divideString(user.getHour(),":");
            if ((author==null && text==null && Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month) && Integer.parseInt(user.getDay())==day && hours[0].equals(""+hour))||
                    (author==null && user.getMessage().contains(Objects.requireNonNull(text))&&Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month) && Integer.parseInt(user.getDay())==day && hours[0].equals(""+hour))||
                    (conditionAutText(user,author,text) && Integer.parseInt(user.getYear())==year && Utils.monthEquals(user.getMonth(),month)&& Integer.parseInt(user.getDay())==day && hours[0].equals(""+hour))
            ) {
                temp+=1;
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.notNullReturn(UserData.getUserDataSubList(),temp);
    }

    public static Object outputPostRG(List<UserData> obj, String regex) {
        UserData.getUserDataSubList().clear();
        int temp=0;
        for (UserData user : obj
        ) {
            temp+= Utils.rtMessage(regex,user.getMessage());
                if(Utils.rtMessage(regex,user.getMessage())!=0)UserData.getUserDataSubList().add(user);
        }
        return Utils.notNullReturn(UserData.getUserDataSubList(),temp);
    }
}
