package com.umberto.database;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;


/**
 * <h1>UserData</h1>
 * La Classe UserData del programma Twitter3 si occupa
 * di orgranizzare i dati raccolti dalla classe JSonLoader
 */
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

    public String getHour() {
        return hour;
    }

    public String getYear() {
        return year;
    }

    @Expose
    String year;
    @Expose
    static List<String> screenList=new ArrayList<>();
    @Expose
    static List<UserData> userDataList = new ArrayList<>();
    @Expose
    static List<UserData> userDataSubList = new ArrayList<>();
    /**
     * Questo metodo è usato per restituire una Stringa contenente ScreenName
     * @return screenName Restituisce lo ScreenName
     */
    public String getScreenName() {
        return screenName;
    }
    /**
     * Questo metodo è usato per ottenere una sottolista di userDataList
     * @return List<UserData> Restituisce userDataSubList
     */
    public static List<UserData> getUserDataSubList() {
        return userDataSubList;
    }
    /**
     * Questo metodo è usato per ottenere la lista userDataList
     * @return List<UserData> Restituisce userDataList
     */
    public static List<UserData> getUserDataList() {
        return userDataList;
    }
    /**
     * Questo metodo è usato per ottenere il mese del messaggio
     * @return String Restituisce month
     */
    public String getMonth() {
        return month;
    }
    /**
     * Questo metodo è usato per ottenere il giorno del messaggio
     * @return String Restituisce day
     */
    public String getDay() {
        return day;
    }
    /**
     * Questo metodo è usato per ottenere il messaggio
     * @return String Restituisce message
     */
    public String getMessage() {
        return message;
    }
    /**
     * Questo metodo è usato per ottenere la data del messaggio
     * @return String Restituisce createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }
    /**
     * Questo metodo è usato per ottenere l'elenco degli screenName
     * @return List<String> Restituisce un elenco di ScreenName
     */
    public static List<String> getScreenList() { return screenList; }

    /**
     * Questo metodo è usato per generare un oggetto di tipo UserData che contiene i dati ottenuti dal JSonLoader
     * @param screenName contiene lo ScreenName dell'utente che si sta aggiungendo alla lista.
     * @param message contiene il testo del messaggio dell'utente che si sta aggiungendo alla lista.
     * @param createdAt contiene la data del messaggio dell'utente che si sta aggiungendo alla lista.
     * @param month contiene il mese del messaggio dell'utente che si sta aggiungendo alla lista.
     * @param day contiene il giorno del messaggio dell'utente che si sta aggiungendo alla lista.
     * @param hour contiene l'ora del messaggio dell'utente che si sta aggiungendo alla lista.
     * @param year contiene l'anno del messaggio dell'utente che si sta aggiungendo alla lista.
     */
    public UserData(String screenName, String message, String createdAt, String month, String day, String hour, String year) {
        this.screenName = screenName;
        this.message = message;
        this.createdAt = createdAt;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.year = year;
    }
    /**
     * Questo metodo è usato per restituire una Stringa contenente le informazioni su un utente UserData
     * @return String una Stringa con i dati dell'utente.
     */
    @Override
    public String toString() {
        return "\bUser{" + ", screen_name='" + screenName + '\'' + ", messaggio='" + message;
    }
}
