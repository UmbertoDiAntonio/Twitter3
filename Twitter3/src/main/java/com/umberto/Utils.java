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


/**
 * La Classe Utils del programma Twitter3 contiene i metodi più utili del programma
 * che ne svolgono tutte le funzioni principali
 *
 */
public class Utils {
    /**
     * il Metodo Utils() è un costruttore vuoto non esegue nulla
     * @deprecated
     */
    @Deprecated
    Utils() {

    }
    public static final String ERROR = "Error";
    public static final String WAITING_DATA ="In Attesa di Dati da Esaminare";
    static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    static boolean justloaded = false;
    static String rtCase="^(RT)";
    static String tagCase="^.+(@.)+.";
    static int rtCont=0;
    static int contAzioni = 0;
    static int cont = 0;
    static Date date=new Date();
    static LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    static Month month = localDate.getMonth();
    static int monthv=localDate.getMonthValue();
    static int day   = localDate.getDayOfMonth();
    static int dday = localDate.getDayOfYear();
    static int aday;

    /**
     * Questo Metodo Restituisce la Posizione da cui si sta eseguendo il Programma
     * @return String: Restituisce la Posizione da cui si sta eseguendo il Programma
     */
    public static String getDataFolder() { // nota: Cartella da cui eseguo il jar, non cartella del jar
        return System.getProperty("user.dir");
    }

    /**
     * Questo Metodo Salva i Dati Forniti in un File Json
     * @param file Contiene il nome che si vuole dare al file
     * @param obj Contiene i dati da salvare
     */
    public static void saveData(String file, Object obj) {
        try (FileWriter writer = new FileWriter(Utils.getDataFolder() + File.separator + file)) {
            gson.toJson(obj, writer);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRORE, Salvataggio dati Fallito", ERROR, JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
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

    /**
     * Questo Metodo divide una Stringa in n Stringhe usando come divisore la ','
     * @param str String: Contiene la Stringa da dividere
     * @return String[]: Contiene le Stringhe divise
     */
    public static String[] divideString(String str) {
        return (str.trim().split(","));
    }

    /**
     * Questo Metodo fa Ottenere la Stringa Regex che identifica un uso di Tag all'interno di una Stringa
     * @return String: Stringa Regex che identifica un uso di Tag all'interno di una Stringa
     */
    public static String getTagCase() { return tagCase; }
    /**
     * Questo Metodo fa Ottenere la Stringa Regex che identifica un uso di ReTweet all'interno di una Stringa
     * @return String: Stringa Regex che identifica un uso di ReTweet all'interno di una Stringa
     */
    public static String getRtCase() {
        return rtCase;
    }

    /**
     * Questo Metodo Incrementa il contatore rtCont ogni volte viene trovata la presenza di una stringa regex all'
     * interno della stringa fornita
     * @param regex String: Stringa regex di cui verrà controllata la presenza
     * @param string String: Stringa contenente il testo su cui deve essere effettuato il controllo
     */
    public static void contRegUses(String regex, String string) {
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                rtCont += 1;
            }
        }
    }

    /**
     * Questo Metodo mostra il valore attuale del contatore di Regex
     * @return int: Restituisce il valore attuale del Contatore di Regex
     */
    public static int getRtCont() {
        return rtCont;
    }

    /**
     * Questo Metodo Azzera il valore del Contatore di Regex
     */
    public static void nullifyRtCont(){
        rtCont=0;
    }

    /**
     * Questo Metodo Incrementa di 1 il Valore di un Contatore di Azioni
     */
    public static void contatoreAzioni() {
        contAzioni += 1;
    }

    /**
     * Questo Metodo Restituisce il Valore Attuale del Contatore di Azioni
     * @return int: Restituisce il Valore Attuale del Contatore di Azioni
     */
    public static int getContAzioni() {
        return contAzioni;
    }

    /**
     * Questo Metodo Azzera il Valore Del Contatore Azioni
     */
    public static void nullifyContAzioni() {
    cont=0;
    }
    /**
     * Questo Metodo Incrementa di 1 il Valore di un Contatore
     */
    public static void contatore() {
        cont += 1;
    }
    /**
     * Questo Metodo Restituisce il Valore Attuale del Contatore
     * @return int: Restituisce il Valore Attuale del Contatore
     */
    public static int getCont() {
        return cont;
    }
    /**
     * Questo Metodo Azzera il Valore Del Contatore
     */
    public static void nullifyCont() {
        cont=0;
    }

    /**
     * Questo Metodo Controlla se un Tweet è di Tendenza
     * @return boolean: true o false se il Numero di ReTweet/Numero Totale è maggiore di 0.5
     */
    public static boolean isTendence() {
        return ((float) getRtCont() / UserData.getUserDataList().size() > 0.5);
    }

    /**
     * Questo Metodo Restituisce una Stringa Diversa in base al Risultato del Controllo isTendence
     * @return String: Restituisce una Stringa Diversa in base al Risultato del Controllo isTendence
     */
    public static String tendence(){
        if(isTendence()){
            return "La Key Inserita è quindi di Tendenza";
        }
        return "La Key Inserita non è quindi di Tendenza";
    }

    /**
     * Questo Metodo Divide una Stringa Fornita in SottoStringhe in corrispondenza di spazi
     * @param str Rappresenta una Stringa composta da molteplici Parole divise da spazi
     * @return String[]: Una Vettore di Stringhe che componevano la stringa fornita, divise in corrispondenza di spazi vuoti
     */
    public static String[] createdAtdivide(String str) {
        return str.split(" ");
    }

    /**
     * Questo Metodo Conta quanti messaggi tra quelli ottenuti dal JSonLoader hanno data corrispondente a quella di oggi
     * @return int: Numero di messaggi che ha come data oggi
     */
    public static int todayMessage(){
        nullifyCont();
        for (UserData user:UserData.getUserDataList()) {
            if(Integer.parseInt(user.getDay())==day){
                contatore();
            }
        }
        return getCont();
    }
    /**
     * Questo Metodo Conta quanti messaggi tra quelli ottenuti dal JSonLoader Sono dei ReTweet
     * @return int: Numero di messaggi ReTweet
     */
    public static int rtMessage(String caso){
        nullifyRtCont();
        for (UserData user:UserData.getUserDataList()) {
            Utils.contRegUses(caso,user.getMessage());
        }
        return getRtCont();
    }

    /**
     * Questo Metodo Restituisce il numero del giorno dell'anno
     * @param messageDay Parametro Contenente la data del messaggio
     * @return int: Restituisce il numero del giorno dell'anno
     */
    static int dayOfYear(int messageDay) {
        if(monthv==1){aday=messageDay;}//gen 31
        if(monthv==2){aday=messageDay+31;}//feb 28
        if(monthv==3){aday=messageDay+31+28;}//mar 31
        if(monthv==4){aday=messageDay+31+28+31;}//apr 30
        if(monthv==5||monthv==6||monthv==7){aday=messageDay+31+28+31+30*(monthv-4);}//mag 31
        if(monthv==8){aday=messageDay+31+28+31+30+30+30+31;}//ago 31
        if(monthv==9){aday=messageDay+31+28+31+30+30+30+31+31;}//set 30
        if(monthv==10){aday=messageDay+31+28+31+30+30+30+31+31+30;}//ott 31
        if(monthv==11){aday=messageDay+31+28+31+30+30+30+31+31+30+31;}//nov 30
        if(monthv==12){aday=messageDay+31+28+31+30+30+30+31+31+30+31+30;}//dic 31
        return (aday);
    }
    /**
     * Questo Metodo Conta quanti messaggi tra quelli ottenuti dal JSonLoader sono di questa settimana
     * @return int: Numero di messaggi di Questa Settimana
     */
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
    /**
     * Questo Metodo Conta quanti messaggi tra quelli ottenuti dal JSonLoader hanno data appartenente a questo Mese
     * @return int: Numero di messaggi che sono di questo mese
     */
    public static int monthMessage(){
        nullifyCont();
        for (UserData user:UserData.getUserDataList()) {
            if(monthEquals(user.getMonth())){
                contatore();
            }
        }
        return getCont();
    }

    /**
     * Questo Metodo Controlla se il mese del messaggio è lo stesso del mese corrente
     * @param usermese Una Stringa che indica il mese del messaggio inviato dall'utente
     * @return boolean: true se è lo stesso mese, false in caso contrario
     */
    static boolean monthEquals(String usermese) {
        for (Month mese : Month.values()) {
            if (mese.name().substring(0,3).equalsIgnoreCase(usermese))
               return mese.getValue() == month.getValue();
        }
        return false;
    }

    /**
     * Questo Metodo crea una finestra in cui espone i risultati di un filtro e li salva in un file
     * @param file Nome del file dove si vogliono salvare i dati
     */
    public static void standardOutputMessage(String file){
        if(file.equals("outputFTA.json")||file.equals("outputFTC.json")) {
            JOptionPane.showMessageDialog(null, "Sono stati trovati " + UserData.getUserDataSubList().size() + " messaggi \n " +
                    getRtCont() + " sono dei ReTweet, il " + (float) getRtCont() / UserData.getUserDataList().size() * 100 + "%\n" +
                    tendence() + "\n" +
                    "Ho salvato i risultati nel file " + file + ", nella cartella\n" + getDataFolder());
        }else if(file.equals("Json.json")&&!UserData.getUserDataList().isEmpty()){ JOptionPane.showMessageDialog(null, "Sono stati trovati " + UserData.getUserDataList().size() + " messaggi \n " +
                "Ho salvato i risultati nel file " + file + ", nella cartella\n" + getDataFolder());
        }else if(file.equals("outputFTU.json")&&!UserData.getUserDataList().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ho salvato i risultati nel file " + file + ", nella cartella\n" + getDataFolder());
        }else{
            JOptionPane.showMessageDialog(null,"ERRORE, Dati non Caricati",ERROR,JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Questo Metodo Stampa un Messaggio di Errore se con i filtri usati non vengono trovati risultati
     */
    public static void noKeyFoundInMessage(){
        JOptionPane.showMessageDialog(null,"Nessun Messaggio contiene la Key Inserita",ERROR,JOptionPane.ERROR_MESSAGE);
    }
}
