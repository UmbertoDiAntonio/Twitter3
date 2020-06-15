package com.umberto;

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


public class JsonLoader {
    public JsonLoader() throws IOException {
        URL url = new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=" + Main.getKey() + "&count=" + Main.getnMessage());
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
            String[] expandedDate=new String[5];
            expandedDate=Utils.createdAtdivide(createdAt);//0=Giorno Settimana 1=Mese 2=Giorno 3=Ora 4=Fuso 5=Anno
            UserData.getUserDataList().add(new UserData(screenName, message, createdAt,expandedDate[1],
                    expandedDate[2],expandedDate[3],expandedDate[5]));
        }
        for (UserData user : UserData.getUserDataList()
        ) {
            UserData.getScreenList().add(user.getScreenName());
        }
    }
}
