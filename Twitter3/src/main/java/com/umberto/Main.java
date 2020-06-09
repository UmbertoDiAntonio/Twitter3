package com.umberto;

import com.google.gson.*;
import com.umberto.database.UserData;
import com.umberto.gui.CreateBox;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    private static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    static boolean one=false;
    static double nMessage=100;
    public static void main(String[] args) throws IOException {
        try {
            nMessage = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserisci il Numero di Messaggi che vuoi esaminare", "es: 100"));
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,"Errore, va Inserito un Numero, assegnato il valore di deafult=100","Errore",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
         URL url = new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=terremoto&count=" + nMessage);
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
        for (int i = 0; i < statuses.size(); i++) {
            JsonElement je3 = statuses.get(i);
            JsonObject singlePost = je3.getAsJsonObject();
            JsonElement je4 = singlePost.get("text");
            JsonElement je5 = singlePost.get("user");
            JsonObject user = je5.getAsJsonObject();
            JsonElement je6 = user.get("name");
            JsonElement je7 = user.get("screen_name");
            String message = je4.getAsString();
            String namel = je6.getAsString();
            String screenname = je7.getAsString();
            UserData.screenList.add(screenname);
            UserData.messageList.add(message);
        }
        ImageIcon icon = new ImageIcon("");
        UserData.screenList.add(0,"ALL");
        String search = (String) JOptionPane.showInputDialog(null, "Seleziona l'utente su cui effetture la ricerca",
                "Lista Utenti", JOptionPane.QUESTION_MESSAGE, icon, UserData.screenList.toArray(), UserData.screenList.get(0));
        String filterText = JOptionPane.showInputDialog(null, "Inserisci le Parole da cercare (separate da una virgola)", "esempio: parola1,parola2,..");
        UserData.divideString(filterText);
        for (int i = 0; i < UserData.messageList.size(); i++) {
            if (UserData.screenList.get(i).contains(search)||search.equals("ALL")) {
                for (int k = 0; k < UserData.filterlist.length; k++) {
                    if (UserData.messageList.get(i).contains(UserData.filterlist[k])) {
                        UserData.userList.add(new UserData(UserData.screenList.get(i), UserData.messageList.get(i)));
                        one=true;
                    }
                }
            }
        }
        if(one) new CreateBox();
            else JOptionPane.showMessageDialog(null,"Nessun messaggio contenente i parametri indicati trovato");
    }
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
