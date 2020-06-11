package com.umberto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.umberto.database.UserData;


import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    Utils() {

    }

    public static final String ERROR = "Error";

    public static String getDataFolder() { // nota: Cartella da cui eseguo il jar, non cartella del jar
        return System.getProperty("user.dir");
    }

    private static Gson gson = new GsonBuilder()
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

    public static void noMultiLoad() {
        justloaded = true;
    }

    public static String[] divideString(String str) {
        return (str.trim().split(","));

    }
    static String rtCase="^(RT)";
    public static String getRtCase() {
        return rtCase;
    }
    static int rtCont=0;
    public static void contRegUses(String regex, String string) {
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
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
    public static void standardOutputMessage(String file){
        JOptionPane.showMessageDialog(null, "Sono stati trovati "+getCont()+" messaggi \n " +
                "" +rtCont+" sono dei ReTweet\n"+
                "Ho salvato i risultati nel file"+file+", nella cartella\n"+getDataFolder());
    }
    public static void noKeyFoundInMessage(){
        JOptionPane.showMessageDialog(null,"Nessun Messaggio contiene la Key Inserita",ERROR,JOptionPane.ERROR_MESSAGE);
    }
}
