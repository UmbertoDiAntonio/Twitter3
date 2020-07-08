package com.umberto.other;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.umberto.database.UserData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * <h1>JSon Loader</h1>
 * \nLa Classe JsonLoader del programma Twitter3 si occupa
 * del ottenimento dei dati
 */
public class JsonLoader {
    /**
     * Questo è il costruttore della classe JsonLoader, stabilice una connessione
     * con l'url del API e ne salva i dati
     *
     * @throws IOException On input error.
     * @see IOException
     */
    public JsonLoader() throws IOException {

        URL url = new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=" + Utils.getKey() + "&count=" + Utils.getnMessage());

        if (Utils.getArgsValue().length == 1) {
            url = new URL(Utils.argsValue[0]);
            //Url by args ;-)
        }


        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        if (connection.getResponseCode() == 400)
            return;
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        JsonElement je = new JsonParser().parse(bufferedReader);
        JsonObject all = je.getAsJsonObject();
        JsonElement je2 = all.get("statuses");
        JsonElement je9 = all.get("search_metadata");
        JsonObject metadata = je9.getAsJsonObject();
        JsonElement je10 = metadata.get("count");
        int count = je10.getAsInt();
        JsonArray statuses = je2.getAsJsonArray();
        for (int i = 0; i < statuses.size(); i++) {
            JsonElement je3 = statuses.get(i);
            JsonObject singlePost = je3.getAsJsonObject();
            JsonElement je4 = singlePost.get("text");
            JsonElement je8 = singlePost.get("created_at");
            JsonElement je5 = singlePost.get("user");
            JsonObject user = je5.getAsJsonObject();
            JsonElement je6 = user.get("name");
            JsonElement je7 = user.get("screen_name");
            String message = je4.getAsString();
            String name = je6.getAsString();
            String screenName = je7.getAsString();
            String createdAt = je8.getAsString();
            String[] completeDate;
            completeDate = Utils.divideString(createdAt, " ");//0=Giorno Settimana 1=Mese 2=Giorno 3=Ora 4=Fuso 5=Anno
            UserData.getUserDataList().add(new UserData(screenName, message, createdAt, completeDate[1],
                    completeDate[2], completeDate[3], completeDate[5]));
        }
        for (UserData user : UserData.getUserDataList()
        ) {
            UserData.getScreenList().add(user.getScreenName());
        }
        Utils.setSpringBootExecutable(true);
    }


}
