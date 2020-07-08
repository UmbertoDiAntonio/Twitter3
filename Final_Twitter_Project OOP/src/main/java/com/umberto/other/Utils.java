package com.umberto.other;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.umberto.database.UserData;

import javax.swing.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La Classe Utils del programma Twitter3 contiene i metodi più utili del programma
 * che ne svolgono tutte le funzioni principali
 *
 */
public class Utils {
    static int nMessage = 1;
    static String key = "";

    /**
     * il Metodo Utils() è un costruttore vuoto non esegue nulla
     * @deprecated
     */
    @Deprecated
    Utils() {

    }
    public static String infopost(int temp) {
        return "Sono Presenti:"+temp+" Elementi contenenti i dati indicati\n\n";
    }
    public static final String ERROR = "Error";
   static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    static boolean justloaded = false;


    static int regCont=0;
    static Date date=new Date();
    static final LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    static final int dayOfMonth = localDate.getDayOfMonth();


    public static int getDayOfMonth() {
        return dayOfMonth;
    }


    public static String notNullReturn(List<UserData> list,int temp){
        if(list.isEmpty()){
            return "Nessun elemento ha i parametri richiesti";
        }else return Utils.infopost(temp)+Utils.saveAsJson(UserData.getUserDataSubList());
    }
    /**
     * Questo Metodo Salva i Dati Forniti in un File Json
     *  Contiene il nome che si vuole dare al file
     * @param obj Contiene i dati da salvare
     */
    public static String saveAsJson(Object obj) {
        return Utils.gson.toJson(obj);
    }
    public static void openWebLink(String link) throws URISyntaxException, IOException {
        Desktop desktop=Desktop.getDesktop();
        desktop.browse(new URI(link));

    }
    /**
     * Questo Metodo serve da controllo per sapere se il Json è stato caricato già 1 volta
     * @return boolean: Indica se il Json è stato già caricato
     */
    public static boolean isJustloaded() {
        return !justloaded;
    }
    /**
     * Questo Metodo serve a impostare lo stato del JSon da non caricato a caricato
     * @param status boolean: contiene lo stato che si vuole impostare, caricato o non caricato (true o false)
     */
    public static void setJustloaded(boolean status) {
        justloaded = status;
    }
    private static boolean springBoot= false;
    public static boolean canUseSpringBoot(){
        return springBoot;
    }
    public static void setSpringBootExecutable(boolean isExecutable){
        springBoot=isExecutable;
    }
    /**
     * Questo Metodo divide una Stringa in n Stringhe usando come divisore la ','
     * @param str String: Contiene la Stringa da dividere
     * @return String[]: Contiene le Stringhe divise
     */
    public static String[] divideString(String str,String regex) {
        return (str.trim().split(regex));
    }
    /**
     * Questo Metodo Conta quanti messaggi tra quelli ottenuti dal JSonLoader Sono dei ReTweet
     * @return int: Numero di messaggi ReTweet
     */
   public static int rtMessage(String regex,String message){
       final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
       final Matcher matcher = pattern.matcher(message);
       regCont =0;
       while (matcher.find()) {
           for (int i = 1; i <= matcher.groupCount(); i++) {
               regCont = 1;
           }
       }
        return regCont;
   }

    /**
     * Questo Metodo Controlla se il mese del messaggio è lo stesso del mese corrente
     * @param usermese Una Stringa che indica il mese del messaggio inviato dall'utente
     * @return boolean: true se è lo stesso mese, false in caso contrario
     */
    static boolean monthEquals(String usermese, Month meseScelto) {
        for (Month mese : Month.values()) {
            if (mese.name().substring(0,3).equalsIgnoreCase(usermese))
               return mese.getValue() == meseScelto.getValue();
        }
        return false;
    }
    static String[] argsValue;

    /**
     * Questo Metoso Salva l'URL passato all'avvio del programma
     * @param argsvalue Contiene l'URL fornito in input
     */
    public static void setArgsValue(String[] argsvalue) {
        Utils.argsValue = argsvalue;
    }

    /**
     * Questo Metodo Restituisce gli argomenti forniti come input all'avvio del programma
     * @return String[]: Restituisce gli argomenti forniti come input all'avvio del programma
     */
    public static String[] getArgsValue() {
        return argsValue;
    }

    /**
     * Questo metodo è usato per impostare un valore intero
     * @param nMessage è usato per contere il numero di messaggi da esaminare.
     */
    public static void setNMessage(int nMessage) {
        if (nMessage <= 0 || nMessage > 100) {
            JOptionPane.showMessageDialog(null, "Errore,Numero Non Consentito, sarà cambiato con 1", "Errore", JOptionPane.ERROR_MESSAGE);
            setNMessage(100);
        }
        Utils.nMessage = nMessage;
    }

    /**
     * Questo metodo è usato per restituire un intero
     * @return int: Restituisce il numero di messaggi scelto.
     */
    public static int getnMessage() {
        return nMessage;
    }

    /**
     * Questo metodo è usato per impostare un valore intero
     * @param key è usato per contere una parola chiave da cercare.
     */
    public static void setKey(String key) {
        Utils.key = key;
    }

    /**
     * Questo metodo è usato per restituire una String
     * @return String: Restituisce la parola chiave scelta
     */
    public static String getKey() {
        return key;
    }
}
