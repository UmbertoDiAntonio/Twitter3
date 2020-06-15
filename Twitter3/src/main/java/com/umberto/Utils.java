package com.umberto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.umberto.database.UserData;


import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    Utils() {

    }

    public static final String ERROR = "Error";
    public static final String WAITING_DATA ="In Attesa di Dati da Esaminare";
    public static String getDataFolder() { // nota: Cartella da cui eseguo il jar, non cartella del jar
        return System.getProperty("user.dir");
    }

    static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public static void saveData(String file, Object obj) {
        try (FileWriter writer = new FileWriter(Utils.getDataFolder() + File.separator + file)) {
            gson.toJson(obj, writer);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRORE, Salvataggio dati Fallito", ERROR, JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static boolean isJustloaded() {
        return justloaded;
    }

    static boolean justloaded = false;
    public static void setJustloaded(boolean status) {
        justloaded = status;
    }
    public static void noMultiLoad() {
        justloaded = true;
    }

    public static String[] divideString(String str) {
        return (str.trim().split(","));

    }
    static String rtCase="^(RT)";

    public static String getTagCase() {
        return tagCase;
    }

    static String tagCase="^.*(@.)*.";
    public static String getRtCase() {
        return rtCase;
    }
    static int rtCont=0;

    public static void contRegUses(String regex, String string) {
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                rtCont += 1;
            }
        }
    }

    public static int getRtCont() {
        return rtCont;
    }
    public static void nullifyRtCont(){
        rtCont=0;
    }

    static int contAzioni = 0;
    public static void contatoreAzioni() {
        cont += 1;
    }
    public static int getContAzioni() {
        return contAzioni;
    }
    public static void nullifyContAzioni() {
    cont=0;
    }

    static int cont = 0;
    public static void contatore() {
        cont += 1;
    }
    public static int getCont() {
        return cont;
    }
    public static void nullifyCont() {
        cont=0;
    }

    public static boolean isTendence() {
        tendence= ((float) getRtCont() / getCont() > 0.5);
        return tendence;
    }
    public static String tendence(){
        if(isTendence()){
            return "La Key Inserita è quindi di Tendenza";
        }
        return "La Key Inserita non è quindi di Tendenza";
    }
    static boolean tendence=false;

    public static String[] createdAtdivide(String str) {
        return str.split(" ");
    }
     static Date date=new Date();
    static LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    static Month month = localDate.getMonth();
    static int monthv=localDate.getMonthValue();
    static int day   = localDate.getDayOfMonth();
    static int dday = localDate.getDayOfYear();
    public static int todayMessage(){
        nullifyCont();
        for (UserData user:UserData.getUserDataList()) {
            if(Integer.parseInt(user.getDay())==day){
                contatore();
            }
        }
        return getCont();
    }
    public static int rtMessage(String caso){
        nullifyRtCont();
        for (UserData user:UserData.getUserDataList()) {
            Utils.contRegUses(caso,user.getMessage());
        }

        return getRtCont();
    }
    static int aday;
    static int dayOfYear(int today) {
        if(monthv==1){aday=today;}//gen 31
        if(monthv==2){aday=today+31;}//feb 28
        if(monthv==3){aday=today+31+28;}//mar 31
        if(monthv==4){aday=today+31+28+31;}//apr 30
        if(monthv==5||monthv==6||monthv==7){aday=today+31+28+31+30*(monthv-4);}//mag 31
        if(monthv==8){aday=today+31+28+31+30+30+30+31;}//ago 31
        if(monthv==9){aday=today+31+28+31+30+30+30+31+31;}//set 30
        if(monthv==10){aday=today+31+28+31+30+30+30+31+31+30;}//ott 31
        if(monthv==11){aday=today+31+28+31+30+30+30+31+31+30+31;}//nov 30
        if(monthv==12){aday=today+31+28+31+30+30+30+31+31+30+31+30;}//dic 31

        return (aday);
    }
    public static int weekMessage(){
        nullifyCont();
        for (UserData user:UserData.getUserDataList()) {

            if(dayOfYear(Integer.parseInt(user.getDay()))==dday||dayOfYear(Integer.parseInt(user.getDay()))==dday-1
                    ||dayOfYear(Integer.parseInt(user.getDay()))==dday-2||dayOfYear(Integer.parseInt(user.getDay()))==dday-3
                    ||dayOfYear(Integer.parseInt(user.getDay()))==dday-4||dayOfYear(Integer.parseInt(user.getDay()))==dday-5
                    ||dayOfYear(Integer.parseInt(user.getDay()))==dday-6){
                contatore();
            }
        }
        return getCont();
    }
    public static int monthMessage(){
        nullifyCont();
        for (UserData user:UserData.getUserDataList()) {
            if(monthEquals(user.getMonth())){
                contatore();
            }
        }
        return getCont();
    }
    static boolean monthEquals(String usermese) {
        for (Month mese : Month.values()) {
            if (mese.name().substring(0,3).equalsIgnoreCase(usermese))
               return mese.getValue() == month.getValue();
        }
        return false;
    }

    public static void standardOutputMessage(String file){
        JOptionPane.showMessageDialog(null, "Sono stati trovati "+getCont()+" messaggi \n " +
                getRtCont()+" sono dei ReTweet, il "+(float)getRtCont()/getCont()*100+"%\n"+
                tendence()+"\n"+
                "Ho salvato i risultati nel file"+file+", nella cartella\n"+getDataFolder());
    }
    public static void noKeyFoundInMessage(){
        JOptionPane.showMessageDialog(null,"Nessun Messaggio contiene la Key Inserita",ERROR,JOptionPane.ERROR_MESSAGE);
    }

}
