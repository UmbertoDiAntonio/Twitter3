package com.umberto.other;

import com.umberto.database.UserData;

import java.time.Month;
import java.util.List;



/**
 * Questa Classe si occupa della generazione di messaggi legati alle richieste fatte al controller
 */
public class OutputGenerator {

    /**
     * @deprecated
     */
    @Deprecated
    OutputGenerator() {    }

    /**
     * Questo metodo controlla gli username e i contenuti dei messaggi
     *
     * @param user   UserData: Contiene i dati di un utente
     * @param author String: Screen_Name di cui si vuole controllare la presenaza
     * @param text   String: Testo di cui si vuole controllare la presenza
     * @return boolean true o false
     */
    private static boolean conditionAutText(UserData user, String author, String text) {
        String[]texts=Utils.filtDiv(text);
        return (user.getScreenName().equals(author) && Utils.checkM(texts,user.getMessage()));
    }
    /**
     * Questo metodo controlla gli username e i contenuti dei messaggi
     *
     * @param user   UserData: Contiene i dati di un utente
     * @param author String: Screen_Name di cui si vuole controllare la presenaza
     * @param text   String: Testo di cui si vuole controllare la presenza
     * @return boolean true o false
     */
    private static boolean conditionAutNullText(UserData user, String author, String text) {
        String[]texts=Utils.filtDiv(text);
        return (author==null && Utils.checkM(texts,user.getMessage()));
    }

    /**
     * Questo Metodo genera una Stringa contenente i dati per la risposta alla chiamata del Controller corrispondente
     *
     * @param obj Lista di UserData, contiene tutti i dati degli utenti
     * @return String: Restituisce tutti i dati di tutti gli utenti
     */
    public static String outputPost(List<UserData> obj) {
        return "Sono Presenti:" + Utils.getnMessage() + " Elementi\n\n" + Utils.saveAsJson(obj);
    }

    /**
     * Questo Metodo genera una Stringa contenente i dati per la risposta alla chiamata del Controller corrispondente
     *
     * @param obj    Lista di UserData
     * @param author String: Screen_Name di cui si vuole controllare la presenaza
     * @return Restituisce i dati degli utenti con lo Screen_name indicato
     */
    public static Object outputPost(List<UserData> obj, String author) {
        UserData.getUserDataSubList().clear();
        int temp = 0;
        for (UserData user : obj
        ) {
            if (user.getScreenName().equals(author)) {
                temp++;
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.notNullReturn(UserData.getUserDataSubList(), temp);
    }


    /**
     * Questo Metodo genera una Stringa contenente i dati per la risposta alla chiamata del Controller corrispondente
     * @param obj    Lista di UserData
     * @param author String: Screen_Name di cui si vuole controllare la presenaza
     * @param text   String: Testo di cui si vuole controllare la presenza
     * @return Restituisce i dati degli utenti con lo Screen_name indicato (se indicato) e contenenti il testo indicato
     */
    public static Object outputPost(List<UserData> obj, String author, String text) {
        UserData.getUserDataSubList().clear();
        int temp = 0;
        for (UserData user : obj
        ) {
            if ((conditionAutNullText(user,author,text)) ||
                    (conditionAutText(user, author, text))) {
                temp++;
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.notNullReturn(UserData.getUserDataSubList(), temp);
    }

    /**
     * Questo Metodo genera una Stringa contenente i dati per la risposta alla chiamata del Controller corrispondente
     *
     * @param obj    Lista di UserData
     * @param author String: Screen_Name di cui si vuole controllare la presenaza
     * @param text   String: Testo di cui si vuole controllare la presenza
     * @param year   int: Anno in cui si vuole cercare
     * @return Restituisce i dati degli utenti con lo Screen_name indicato (se indicato), contenenti il testo indicato (se indicato), nell'anno inserito
     */
    public static Object outputPost(List<UserData> obj, String author, String text, int year) {
        UserData.getUserDataSubList().clear();
        int temp = 0;
        for (UserData user : obj
        ) {
            if (((author == null && text == null && Integer.parseInt(user.getYear()) == year) ||
                    conditionAutNullText(user,author,text) && Integer.parseInt(user.getYear()) == year) ||
                    (conditionAutText(user, author, text) && Integer.parseInt(user.getYear()) == year)
            ) {
                temp++;
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.notNullReturn(UserData.getUserDataSubList(), temp);
    }

    /**
     * Questo Metodo genera una Stringa contenente i dati per la risposta alla chiamata del Controller corrispondente
     *
     * @param obj    Lista di UserData
     * @param author String: Screen_Name di cui si vuole controllare la presenaza
     * @param text   String: Testo di cui si vuole controllare la presenza
     * @param year   int: Anno in cui si vuole cercare
     * @param month  Month: Mese in cui si vuole cercare
     * @return Restituisce i dati degli utenti con lo Screen_name indicato (se indicato), contenenti il testo indicato (se indicato), nell'anno e mese inseriti
     */
    public static Object outputPost(List<UserData> obj, String author, String text, int year, Month month) {
        UserData.getUserDataSubList().clear();
        int temp = 0;
        for (UserData user : obj
        ) {
            if ((author == null && text == null && Integer.parseInt(user.getYear()) == year && Utils.monthEquals(user.getMonth(), month)) ||
                    (conditionAutNullText(user,author,text) && Integer.parseInt(user.getYear()) == year && Utils.monthEquals(user.getMonth(), month)) ||
                    (conditionAutText(user, author, text) && Integer.parseInt(user.getYear()) == year && Utils.monthEquals(user.getMonth(), month))
            ) {
                temp++;
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.notNullReturn(UserData.getUserDataSubList(), temp);
    }

    /**
     * Questo Metodo genera una Stringa contenente i dati per la risposta alla chiamata del Controller corrispondente
     *
     * @param obj    Lista di UserData
     * @param author String: Screen_Name di cui si vuole controllare la presenaza
     * @param text   String: Testo di cui si vuole controllare la presenza
     * @param year   int: Anno in cui si vuole cercare
     * @param month  Month: Mese in cui si vuole cercare
     * @param day    int: Giorno in cui si vuole cercare
     * @return Restituisce i dati degli utenti con lo Screen_name indicato (se indicato), contenenti il testo indicato (se indicato), nell'anno, mese e giorno inseriti
     */
    public static Object outputPost(List<UserData> obj, String author, String text, int year, Month month, int day) {
        UserData.getUserDataSubList().clear();
        int temp = 0;
        for (UserData user : obj
        ) {
            if ((author == null && text == null && Integer.parseInt(user.getYear()) == year && Utils.monthEquals(user.getMonth(), month) && Integer.parseInt(user.getDay()) == day) ||
                    (conditionAutNullText(user,author,text) && Integer.parseInt(user.getYear()) == year && Utils.monthEquals(user.getMonth(), month) && Integer.parseInt(user.getDay()) == day) ||
                    (conditionAutText(user, author, text) && Integer.parseInt(user.getYear()) == year && Utils.monthEquals(user.getMonth(), month) && Integer.parseInt(user.getDay()) == day)
            ) {
                temp++;
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.notNullReturn(UserData.getUserDataSubList(), temp);
    }

    /**
     * Questo Metodo genera una Stringa contenente i dati per la risposta alla chiamata del Controller corrispondente
     *
     * @param obj    Lista di UserData
     * @param author String: Screen_Name di cui si vuole controllare la presenaza
     * @param text   String: Testo di cui si vuole controllare la presenza
     * @param year   int: Anno in cui si vuole cercare
     * @param month  Month: Mese in cui si vuole cercare
     * @param day    int: Giorno in cui si vuole cercare
     * @param hour   int: Ora in cui si vuole cercare
     * @return Restituisce i dati degli utenti con lo Screen_name indicato (se indicato), contenenti il testo indicato (se indicato), nell'anno, mese, giorno e ora inseriti
     */
    public static Object outputPost(List<UserData> obj, String author, String text, int year, Month month, int day, int hour) {
        UserData.getUserDataSubList().clear();
        int temp = 0;
        for (UserData user : obj
        ) {
            String[] hours = Utils.divideString(user.getHour(), ":");
            if ((author == null && text == null && Integer.parseInt(user.getYear()) == year && Utils.monthEquals(user.getMonth(), month) && Integer.parseInt(user.getDay()) == day && hours[0].equals("" + hour)) ||
                    (conditionAutNullText(user,author,text) && Integer.parseInt(user.getYear()) == year && Utils.monthEquals(user.getMonth(), month) && Integer.parseInt(user.getDay()) == day && hours[0].equals("" + hour)) ||
                    (conditionAutText(user, author, text) && Integer.parseInt(user.getYear()) == year && Utils.monthEquals(user.getMonth(), month) && Integer.parseInt(user.getDay()) == day && hours[0].equals("" + hour))
            ) {
                temp += 1;
                UserData.getUserDataSubList().add(user);
            }
        }
        return Utils.notNullReturn(UserData.getUserDataSubList(), temp);
    }

    /**
     * Questo Metodo genera una Stringa contenente i dati per la risposta alla chiamata del Controller corrispondente
     *
     * @param obj   Lista di UserData, contiene tutti i dati degli utenti
     * @param regex String: Regex da cercare nel testo
     * @return String: Restituisce i dati degli utenti i cui messsaggi contengono la regex indicata
     */
    public static Object outputPostRG(List<UserData> obj, String regex) {
        UserData.getUserDataSubList().clear();
        int temp = 0;
        for (UserData user : obj
        ) {
            temp += Utils.rtMessage(regex, user.getMessage());
            if (Utils.rtMessage(regex, user.getMessage()) != 0) UserData.getUserDataSubList().add(user);
        }
        return Utils.notNullReturn(UserData.getUserDataSubList(), temp);
    }
}
