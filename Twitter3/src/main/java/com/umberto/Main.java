package com.umberto;

import com.google.gson.*;
import com.umberto.gui.CreateBox;
import com.umberto.database.UserData;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.umberto.database.*;
public class Main{

    private static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    public static void main(String[] args) throws IOException {
        String filterName=JOptionPane.showInputDialog(null,"Inserisci L'UserName dell'utente da cercare","inserisci qui..");
        String filterText=JOptionPane.showInputDialog(null,"Inserisci le Parole da cercare (separate da una virgola)","esempio: parola1,parola2,..");
        UserData.divideString(filterText);
        JOptionPane.showMessageDialog(null,"Effetto la ricerca sull'utente "+filterName+" cercando le key ");
double n=Integer.parseInt(JOptionPane.showInputDialog(null,"Inserisci il Numero di Messaggi che vuoi esaminare","es: 100"));
        URL url = new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=terremoto&count="+n);
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
           JsonElement je7=user.get("screen_name");
           String textl = je4.getAsString();
           String namel= je6.getAsString();
           String screen_namel=je7.getAsString();
           UserData.userList.add(new UserData(namel,screen_namel,textl));
           if(namel.contains(filterName)) {
               for(int k=0;k<UserData.filterlist.length;k++){
                   if(textl.contains(UserData.filterlist[k])){
                       //UserData.addUser(name,screen_name,text);
                   }
               }
           }

       } new CreateBox();
    }
    public static Vector<String> FullNameList=new Vector<>();
    protected static Vector<String> FullScreenNameList=new Vector<>();
    protected static Vector<String> FullTextList=new Vector<>();
    public static void saveData(String file, Object obj) {
        try (FileWriter writer = new FileWriter(getDataFolder() + File.separator + file)) {
            gson.toJson(obj, writer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private static String getDataFolder() { // nota: Cartella da cui eseguo il jar, non cartella del jar
        return System.getProperty("user.dir");
    }



}
