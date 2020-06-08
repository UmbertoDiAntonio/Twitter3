package com.umberto;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.umberto.data.Data;
import com.google.gson.reflect.TypeToken;


import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main{
    @Expose
    private static String  message;
    @Expose
    private static String  user;
    @Expose
    private static String[] filterlist;
    static boolean  continua=true;

    public Main(String message,String user){
        this.message=message;
        this.user=user;
    }
    private static Gson gson = new GsonBuilder()
            .setPrettyPrinting() // formattazione leggibile, se lo togli è + efficiente su file ma meno leggible
            .disableHtmlEscaping() // formattazione
            .excludeFieldsWithoutExposeAnnotation() // non salvare variabili che non hanno @Expose
            .create(); // genera il costruttore di gson
public static void divideString(String str){
filterlist=str.split(",");
}
    public static void main(String[] args) throws IOException {
        String filterName=JOptionPane.showInputDialog(null,"Inserisci L'UserName dell'utente da cercare","inserisci qui..");
        String filterText=JOptionPane.showInputDialog(null,"Inserisci le Parole da cercare (separate da una virgola)","esempio: parola1,parola2,..");
        divideString(filterText);
        JOptionPane.showMessageDialog(null,"Effetto la ricerca sull'utente "+filterName+" cercando le key ");
        URL url = new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=terremoto&count=100");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        if (connection.getResponseCode() == 400)
            return;
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        JsonElement je = new JsonParser().parse(bufferedReader);

        JsonObject all = je.getAsJsonObject();
        JsonElement je2 = all.get("statuses");

        JsonArray statuses = je2.getAsJsonArray();
       for(int i=0;i<statuses.size();i++) {
           JsonElement je3 = statuses.get(i);

           JsonObject singlePost = je3.getAsJsonObject();
           JsonElement je4 = singlePost.get("text");
           JsonElement je5 = singlePost.get("user");
           JsonObject user=je5.getAsJsonObject();
           JsonElement je6=user.get("name");
           String text = je4.getAsString();
           String name= je6.getAsString();

           if(name.contains(filterName)) {
               for(int k=0;k<filterlist.length;k++){
                   if(text.contains(filterlist[k])){
                       List.add(new Main(text,name));
                   }
               }


           }

       }
    }
    public static void saveData(String file, Object obj) {
        try (FileWriter writer = new FileWriter(getDataFolder() + File.separator + file)) {
            gson.toJson(obj, writer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void loadData(String file) {
        String path = getDataFolder() + File.separator + file;
        if (Files.isReadable(Paths.get(path))) { // assicuro che il file esista e sia leggibile, se non c'è non carico un cazz
            try (Reader reader = new FileReader(path)) {
                List = new Gson().fromJson(reader, new TypeToken<List<Data>>() {
                }.getType());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else JOptionPane.showMessageDialog(null,"Fail");
    }
    private static String getDataFolder() { // Cartella da cui eseguo il jar, non cartella del jar attenzione
        return System.getProperty("user.dir");
    }

    public static List<Main> List = new ArrayList<>();

    public static java.util.List<Main> getList() {
        return List;
    }
}
