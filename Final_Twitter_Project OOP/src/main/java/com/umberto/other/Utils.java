package com.umberto.other;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.umberto.database.UserData;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La Classe Utils del programma Twitter3 contiene i metodi più utili del programma
 * che ne svolgono tutte le funzioni principali
 */
public class Utils {
    static int nMessage = 1;
    static String key = "";
    public static final String ERROR = "Error";
    static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    static boolean jsonOpened = false;
    static int regCont = 0;
    private static boolean springBoot = false;
    static String[] argsValue;
    static String[] blacklist;

    /**
     * il Metodo Utils() è un costruttore vuoto non esegue nulla
     *
     * @deprecated
     */
    @Deprecated
    Utils() {

    }

    /**
     * Questo Metodo genera una Stringa in cui viene indicato quanti risultati sono stati ottenuti dalla ricerca
     *
     * @param temp int rappresenta il numero di risultati ottenuto
     * @return String Stringa in cui viene indicato quanti risultati sono stati ottenuti dalla ricerca
     */
    public static String infopost(int temp) {
        return "Sono Presenti:" + temp + " Elementi contenenti i dati indicati\n\n";
    }

    /**
     * Questo Metodo Controlla che una lista non sia vuota, se contiene elementi stampa una Stringa contenente i risultati della ricerca
     *
     * @param list Lista di elementi
     * @param temp valore intero per contare le interazioni
     */
    public static String notNullReturn(List<UserData> list, int temp) {
        if (list.isEmpty()) {
            return "Nessun elemento ha i parametri richiesti";
        } else return Utils.infopost(temp) + Utils.saveAsJson(UserData.getUserDataSubList());
    }

    /**
     * Questo Metodo Salva i Dati Forniti in formato Json
     *
     * @param obj Contiene i dati da salvare
     */
    public static String saveAsJson(Object obj) {
        return Utils.gson.toJson(obj);
    }

    /**
     * Questo Metodo stabilisce una connessione con un url fornito
     *
     * @param link Contiene l'http a cui ci si vuole connettere
     * @throws URISyntaxException URL non corretto
     * @throws IOException        Errore di Input
     * @see URISyntaxException
     * @see IOException
     */
    public static void openWebLink(String link) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI(link));
    }

    /**
     * Questo Metodo serve da controllo per sapere se il Json è stato caricato già 1 volta
     *
     * @return boolean: Indica se il Json è stato già caricato
     */
    public static boolean neverOpened() {
        return !jsonOpened;
    }

    /**
     * Questo Metodo serve a impostare lo stato del JSon da non caricato a caricato
     *
     * @param status boolean: contiene lo stato che si vuole impostare, caricato o non caricato (true o false)
     */
    public static void setJsonOpened(boolean status) {
        jsonOpened = status;
    }

    /**
     * Questo Metodo serve a controllare lo stato di SpringBoot non caricabile a caricabile
     *
     * @return boolean: contiene lo stato attuale, caricatbile o non caricabile (true o false)
     */
    public static boolean canUseSpringBoot() {
        return springBoot;
    }
    /**
     * Questo Metodo serve a controllare la presenza di : in una stringa e dividerla con delle accortezze
     * @param str Stringa che si vuole controllare
     * @return String[] una String[] contenenti le varie parti della stringa principale
     */
public static String[] filtDiv(String str){
        String[] divStr=new String[20];
    if(str.contains(":")) {
        divStr = divideString(str, ":");
        int k = 0;
        for (String s : divStr
        ) {
            if (s != null) {
                divStr[k] = s.trim();
            } else break;
            k++;
        }
    }
    else divStr[0]=str;
    return divStr;
}

    /**
     *  Questo Metodo serve a controllare la presenza di una  piu parole in una stringa
     * @param texts String[] contenente le parle di cui si vuole controllare la presenza
     * @param userMessage String testo in cui si vuole cercare
     * @return boolean (true o false)
     */
public static boolean checkM(String[] texts,String userMessage){
    boolean find=false;
    if(texts[0].equals("blacklist")){
        for (String blackWord:blacklist) {
            find=userMessage.contains(Objects.requireNonNull(blackWord));
            if(find){
                break;
            }
        }
    }else
        for (String text:texts) {
           find=userMessage.contains(Objects.requireNonNull(text));
           if(find){
               break;
           }
        }
    return find;
}
    /**
     * Questo Metodo serve a controllare la presenza di : in una stringa a dividerla con delle accortezze e salvarla
     * @param str Stringa che si vuole salvare
     * @return boolean una String[] contenenti le varie parti della stringa principale
     */
    public static String saveList(String str){
        if(str.contains(":")) {
            blacklist = divideString(str, ":");
            int k = 0;
            for (String s : blacklist
            ) {
                if (s != null) {
                    blacklist[k] = s.trim();
                } else break;
                k++;
            }
        }
        else
            return "La Lista inserita non è valida";
        return "Lista Salvata";
    }
    /**
     * Questo Metodo serve a impostare lo stato di SpringBoot a non caricabile a caricabile
     *
     * @param isExecutable boolean: contiene lo stato che si sta impostando, caricatbile o non caricabile (true o false)
     */
    public static void setSpringBootExecutable(boolean isExecutable) {
        springBoot = isExecutable;
    }

    /**
     * Questo Metodo divide una Stringa in n Stringhe, dividendole in corrispondenza di una sequenza o carattere a scelta
     *
     * @param str   String: Contiene la Stringa da dividere
     * @param regex String: Contiene la Stringa o carattere divisore
     * @return String[]: Contiene le Stringhe divise
     */
    public static String[] divideString(String str, String regex) {
        return (str.trim().split(regex));
    }

    /**
     * Questo Metodo Incrementa un contatore se il messaggio contiene la regex
     *
     * @return int: Numero di messaggi ReTweet
     */
    public static int rtMessage(String regex, String message) {
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(message);
        regCont = 0;
        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                regCont = 1;
            }
        }
        return regCont;
    }

    /**
     * Questo Metodo Controlla se il mese del messaggio è lo stesso del mese corrente
     *
     * @param usermese Una Stringa che indica il mese del messaggio inviato dall'utente
     * @return boolean: true se è lo stesso mese, false in caso contrario
     */
    static boolean monthEquals(String usermese, Month meseScelto) {
        for (Month mese : Month.values()) {
            if (mese.name().substring(0, 3).equalsIgnoreCase(usermese))
                return mese.getValue() == meseScelto.getValue();
        }
        return false;
    }

    /**
     * Questo Metoso Salva l'URL passato all'avvio del programma
     *
     * @param argsvalue Contiene l'URL fornito in input
     */
    public static void setArgsValue(String[] argsvalue) {
        Utils.argsValue = argsvalue;
    }

    /**
     * Questo Metodo Restituisce gli argomenti forniti come input all'avvio del programma
     *
     * @return String[]: Restituisce gli argomenti forniti come input all'avvio del programma
     */
    public static String[] getArgsValue() {
        return argsValue;
    }

    /**
     * Questo metodo è usato per impostare un valore intero
     *
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
     *
     * @return int: Restituisce il numero di messaggi scelto.
     */
    public static int getnMessage() {
        return nMessage;
    }

    /**
     * Questo metodo è usato per impostare un valore intero
     *
     * @param key è usato per contere una parola chiave da cercare.
     */
    public static void setKey(String key) {
        Utils.key = key;
    }

    /**
     * Questo metodo è usato per restituire una String
     *
     * @return String: Restituisce la parola chiave scelta
     */
    public static String getKey() {
        return key;
    }
}
