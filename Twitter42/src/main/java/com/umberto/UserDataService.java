package com.umberto;

import net.minidev.json.JSONValue;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDataService {
            /**
         * Questo è il costruttore della classe JsonLoader, stabilice una connessione
         * con l'url del API e ne salva i dati
         *
         * @throws IOException On input error.
         * @see IOException
         */
/*            private static List<UserData> users = new ArrayList<>();
            static{


            String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=" + "terremoto" + "&count=" +"100";
            //e.g. https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/search/tweets.json?q=spacex&count=100&lang=en
            String fileName = "";
          //  if(UserDataService.argsValue.length == 1) {
           //     url = UserDataService.argsValue[0]; //Url by args ;-)
            //}

            try {
                URLConnection openConnection = new URL(url).openConnection();
                InputStream in = openConnection.getInputStream();

                String data = "";
                String line = "";
                try {
                    InputStreamReader inR = new InputStreamReader( in );
                    BufferedReader buf = new BufferedReader( inR );

                    while ( ( line = buf.readLine() ) != null ) {
                        data=data.concat(line);
                    }
                } finally {
                    in.close();
                }
                //JSONArray obj = (JSONArray) JSONValue.parseWithException(data);	//parse JSON Array
                JSONObject obj = (JSONObject) JSONValue.parseWithException(data);	 //parse JSON Object

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        static String[] argsValue;

        /**
         * Questo Metoso Salva l'URL passato all'avvio del programma
         * @param argsvalue Contiene l'URL fornito in input
         *//*
        public static void setArgsValue(String[] argsvalue) {
            UserDataService.argsValue = argsvalue;
        }

        /**
         * Questo Metodo Restituisce gli argomenti forniti come input all'avvio del programma
         * @return String[]: Restituisce gli argomenti forniti come input all'avvio del programma
         */
 /*       public static String[] getArgsValue() {
            return argsValue;
        }
*/
    }


