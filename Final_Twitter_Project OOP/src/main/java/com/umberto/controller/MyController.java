package com.umberto.controller;

import com.umberto.database.UserData;
import com.umberto.other.OutputGenerator;
import com.umberto.other.Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.UndeclaredThrowableException;
import java.time.Month;

/**
 * Controller dell'applicazione che gestisce tutte le rotte della rest API
 */
@RestController
public class MyController {
    /**
     * Rotta che mostra i dati recuperati dal JSon, non filtrati, sotto forma di JSON
     * @return Restituisce un JSON contenente i dati, eventualmente filtrati
     */
    @GetMapping(value = "/post", produces = "application/json")
    public Object getAllPost() {
        return OutputGenerator.outputPost(UserData.getUserDataList());
    }
    /**
     * Rotta che mostra i messaggi di un utente, recuperati dal JSon, non filtrati, sotto forma di JSON
     * @param list lista che si vuole salvare
     * @return Restituisce un JSON contenente i messaggi di un utente, non filtrati
     */
    @GetMapping(value = "/setblacklist/{list}", produces = "application/json")
    public Object setList(@PathVariable("list") String list) {
        return Utils.saveList(list);
    }
    /**
     * Rotta che mostra i dati recuperati dal JSon, non filtrati, sotto forma di JSON
     * @return Restituisce un JSON contenente i dati, eventualmente filtrati
     */
    @GetMapping(value = "/post/author", produces = "application/json")
    public Object getAllPost2() {
        return OutputGenerator.outputPost(UserData.getUserDataList());
    }

    /**
     * Rotta che mostra i messaggi di un utente, recuperati dal JSon, non filtrati, sotto forma di JSON
     * @param author Screen_Name dell'utente di cui si vogliono selezionare i messaggi
     * @return Restituisce un JSON contenente i messaggi di un utente, non filtrati
     */
    @GetMapping(value = "/post/author/{author}", produces = "application/json")
    public Object getAllPostOfA(@PathVariable("author") String author) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author);
    }
    /**
     * Rotta che mostra i messaggi di un utente, recuperati dal JSon,  filtrati in base al contenuto, sotto forma di JSON
     * @param author Screen_Name dell'utente di cui si vogliono selezionare i messaggi
     * @param message Stringa che deve essere contenuta nel messaggio
     * @return Restituisce un JSON contenente i messaggi di un utente, filtrati in base al contenuto
     */
    @GetMapping(value = "/post/author/{author}/contains/{message}", produces = "application/json")
    public Object getAllPostOfAWithM(@PathVariable("author") String author, @PathVariable("message") String message) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author, message);
    }
    /**
     * Rotta che mostra tutti messaggi, recuperati dal JSon,  filtrati in base al contenuto, sotto forma di JSON
     * @param message Stringa che deve essere contenuta nel messaggio
     * @return Restituisce un JSON contenente tutti messaggi, filtrati in base al contenuto
     */
    @GetMapping(value = "/post/author/contains/{message}", produces = "application/json")
    public Object getAllPostWithM(@PathVariable("message") String message) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, message);
    }
    /**
     * Rotta che mostra i messaggi di un utente, recuperati dal JSon,  filtrati in base al contenuto e all'anno di scrittura, sotto forma di JSON
     * @param author Screen_Name dell'utente di cui si vogliono selezionare i messaggi
     * @param message Stringa che deve essere contenuta nel messaggio
     * @param year Anno di Scrittura del messaggio
     * @return Restituisce un JSON contenente i messaggi di un utente, filtrati in base al contenuto e all'anno di scrittura
     */
    @GetMapping(value = "/post/author/{author}/contains/{message}/year/{year}", produces = "application/json")
    public Object getAllPostOfAWithMAndY(@PathVariable("author") String author, @PathVariable("message") String message, @PathVariable("year") int year) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author, message, year);
    }
    /**
     * Rotta che mostra tutti messaggi, recuperati dal JSon,  filtrati in base al contenuto e all'anno di scrittura, sotto forma di JSON
     * @param message Stringa che deve essere contenuta nel messaggio
     * @param year Anno di Scrittura del messaggio
     * @return Restituisce un JSON contenente tutti messaggi, filtrati in base al contenuto e all'anno di scrittura
     */
    @GetMapping(value = "/post/author/contains/{message}/year/{year}", produces = "application/json")
    public Object getAllPostWhitMAndY(@PathVariable("message") String message, @PathVariable("year") int year) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, message, year);
    }
    /**
     * Rotta che mostra tutti messaggi, recuperati dal JSon,  filtrati in base all'anno di scrittura, sotto forma di JSON
     * @param year Anno di Scrittura del messaggio
     * @return Restituisce un JSON contenente tutti i messaggi, filtrati in base all'anno di scrittura
     */
    @GetMapping(value = "/post/author/contains/year/{year}", produces = "application/json")
    public Object getAllPostWithY(@PathVariable("year") int year) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, null, year);
    }
    /**
     * Rotta che mostra i messaggi di un utente, recuperati dal JSon, filtrati in base al contenuto, all'anno di scrittura e al mese, sotto forma di JSON
     * @param author Screen_Name dell'utente di cui si vogliono selezionare i messaggi
     * @param message Stringa che deve essere contenuta nel messaggio
     * @param year Anno di Scrittura del messaggio
     * @param month Mese di Scrittura del messaggio
     * @return Restituisce un JSON contenente i messaggi di un utente, filtrati in base al contenuto, all'anno di scrittura e al mese
     */
    @GetMapping(value = "/post/author/{author}/contains/{message}/year/{year}/month/{month}", produces = "application/json")
    public Object getAllPostOfAWithMandYandM(@PathVariable("author") String author, @PathVariable("message") String message,
                   @PathVariable("year") int year, @PathVariable("month") Month month) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author, message, year, month);
    }
    /**
     * Rotta che mostra tutti i messaggi, recuperati dal JSon, filtrati in base al contenuto, all'anno di scrittura e al mese, sotto forma di JSON
     * @param message Stringa che deve essere contenuta nel messaggio
     * @param year Anno di Scrittura del messaggio
     * @param month Mese di Scrittura del messaggio
     * @return Restituisce un JSON contenente tutti i messaggi, filtrati in base al contenuto, all'anno di scrittura e al mese
     */
    @GetMapping(value = "/post/author/contains/{message}/year/{year}/month/{month}", produces = "application/json")
    public Object getAllPostWithMandYandM(@PathVariable("message") String message, @PathVariable("year") int year,
                   @PathVariable("month") Month month) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, message, year, month);
    }
    /**
     * Rotta che mostra tutti i messaggi, recuperati dal JSon, filtrati in base all'anno di scrittura e al mese, sotto forma di JSON
     * @param year Anno di Scrittura del messaggio
     * @param month Mese di Scrittura del messaggio
     * @return Restituisce un JSON contenente tutti i messaggi, filtrati in base all'anno di scrittura e al mese
     */
    @GetMapping(value = "/post/author/contains/year/{year}/month/{month}", produces = "application/json")
    public Object getAllPostWithYandM(@PathVariable("year") int year, @PathVariable("month") Month month) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, null, year, month);
    }
    /**
     * Rotta che mostra i messaggi di un utente, recuperati dal JSon, filtrati in base al contenuto, all'anno di scrittura, al mese e al giorno, sotto forma di JSON
     * @param author Screen_Name dell'utente di cui si vogliono selezionare i messaggi
     * @param message Stringa che deve essere contenuta nel messaggio
     * @param year Anno di Scrittura del messaggio
     * @param month Mese di Scrittura del messaggio
     * @param day Giorno di Scrittura del messaggio
     * @return Restituisce un JSON contenente i messaggi di un utente, filtrati in base al contenuto, all'anno di scrittura, al mese e al giorno
     */
    @GetMapping(value = "/post/author/{author}/contains/{message}/year/{year}/month/{month}/day/{day}", produces = "application/json")
    public Object getAllPostOfAWithMandYandMandD(@PathVariable("author") String author, @PathVariable("message") String message,
                   @PathVariable("year") int year, @PathVariable("month") Month month,
                   @PathVariable("day") int day) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author, message, year, month, day);
    }
    /**
     * Rotta che mostra tutti i messaggi, recuperati dal JSon, filtrati in base al contenuto, all'anno di scrittura, al mese e al giorno, sotto forma di JSON
     * @param message Stringa che deve essere contenuta nel messaggio
     * @param year Anno di Scrittura del messaggio
     * @param month Mese di Scrittura del messaggio
     * @param day Giorno di Scrittura del messaggio
     * @return Restituisce un JSON contenente tutti i messaggi, filtrati in base al contenuto, all'anno di scrittura, al mese e al giorno
     */
    @GetMapping(value = "/post/author/contains/{message}/year/{year}/month/{month}/day/{day}", produces = "application/json")
    public Object getAllPostWithMandYandMandD(@PathVariable("message") String message, @PathVariable("year") int year,
                   @PathVariable("month") Month month, @PathVariable("day") int day) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, message, year, month, day);
    }
    /**
     * Rotta che mostra tutti i messaggi, recuperati dal JSon, filtrati in base all'anno di scrittura, al mese e al giorno, sotto forma di JSON
     * @param year Anno di Scrittura del messaggio
     * @param month Mese di Scrittura del messaggio
     * @param day Giorno di Scrittura del messaggio
     * @return Restituisce un JSON contenente tutti i messaggi, filtrati in base all'anno di scrittura, al mese e al giorno
     */
    @GetMapping(value = "/post/author/contains/year/{year}/month/{month}/day/{day}", produces = "application/json")
    public Object getAllPostWithYandMandD(@PathVariable("year") int year, @PathVariable("month") Month month,
                   @PathVariable("day") int day) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, null, year, month, day);
    }
    /**
     * Rotta che mostra i messaggi di un utente, recuperati dal JSon, filtrati in base al contenuto, all'anno di scrittura, al mese, al giorno e all'ora, sotto forma di JSON
     * @param author Screen_Name dell'utente di cui si vogliono selezionare i messaggi
     * @param message Stringa che deve essere contenuta nel messaggio
     * @param year Anno di Scrittura del messaggio
     * @param month Mese di Scrittura del messaggio
     * @param day Giorno di Scrittura del messaggio
     * @param hour Ora di Scrittura del messaggio
     * @return Restituisce un JSON contenente i messaggi di un utente, filtrati in base al contenuto, all'anno di scrittura, al mese, al giorno e all'ora
     */
    @GetMapping(value = "/post/author/{author}/contains/{message}/year/{year}/month/{month}/day/{day}/hour/{hour}", produces = "application/json")
    public Object getAllPostOfAWithMandYandMandDandH(@PathVariable("author") String author, @PathVariable("message") String message,
                   @PathVariable("year") int year, @PathVariable("month") Month month,
                   @PathVariable("day") int day, @PathVariable("hour") int hour) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author, message, year, month, day, hour);
    }
    /**
     * Rotta che mostra tutti i messaggi, recuperati dal JSon, filtrati in base al contenuto, all'anno di scrittura, al mese, al giorno e all'ora, sotto forma di JSON
     * @param message Stringa che deve essere contenuta nel messaggio
     * @param year Anno di Scrittura del messaggio
     * @param month Mese di Scrittura del messaggio
     * @param day Giorno di Scrittura del messaggio
     * @param hour Ora di Scrittura del messaggio
     * @return Restituisce un JSON contenente tutti i messaggi, filtrati in base al contenuto, all'anno di scrittura, al mese, al giorno e all'ora
     */
    @GetMapping(value = "/post/author/contains/{message}/year/{year}/month/{month}/day/{day}/hour/{hour}", produces = "application/json")
    public Object getAllPostWithMandYandMandDandH(@PathVariable("message") String message, @PathVariable("year") int year,
                   @PathVariable("month") Month month, @PathVariable("day") int day,
                   @PathVariable("hour") int hour) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, message, year, month, day, hour);
    }
    /**
     * Rotta che mostra tutti i messaggi, recuperati dal JSon, filtrati in base all'anno di scrittura, al mese, al giorno e all'ora, sotto forma di JSON
     * @param year Anno di Scrittura del messaggio
     * @param month Mese di Scrittura del messaggio
     * @param day Giorno di Scrittura del messaggio
     * @param hour Ora di Scrittura del messaggio
     * @return Restituisce un JSON contenente tutti i messaggi, filtrati in base all'anno di scrittura, al mese, al giorno e all'ora
     */
    @GetMapping(value = "/post/author/contains/year/{year}/month/{month}/day/{day}/hour/{hour}", produces = "application/json")
    public Object getAllPostWithYandMandDandH(@PathVariable("year") int year, @PathVariable("month") Month month,
                   @PathVariable("day") int day, @PathVariable("hour") int hour) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, null, year, month, day, hour);
    }
    /**
     * Rotta che mostra i dati recuperati dal JSon, filtrati tramite una regex per il ReTweet, sotto forma di JSON
     * @return Restituisce un JSON contenente i dati, filtrati tramite una regex per il ReTweet
     */
    @GetMapping(value = "/post/author/contains/retweet", produces = "application/json")
    public Object getPostReTweet() {
        return OutputGenerator.outputPostRG(UserData.getUserDataList(),"^(RT)");
    }
    /**
     * Rotta che mostra i dati recuperati dal JSon, filtrati tramite una regex per il Tag, sotto forma di JSON
     * @return Restituisce un JSON contenente i dati, filtrati tramite una regex per il Tag
     */
    @GetMapping(value = "/post/author/contains/tag", produces = "application/json")
    public Object getPostTag() {
        return OutputGenerator.outputPostRG(UserData.getUserDataList(),"^.+(@.)+.");
    }
}