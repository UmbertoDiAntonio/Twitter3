package com.umberto.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Classe che implementa il controller utilizzato per mostrare il frontend dell'applicazione all'utente
 */
@Controller
public class IndexController implements ErrorController{
    private static final String PATH = "/error";
    /**
     * Rotta in cui verrà restituito un errore in caso mancata mappatura
     * @return Messaggio di Errore
     */
    @Override
    @RequestMapping(PATH)
    @ResponseBody
    public String getErrorPath() {
        return "Error: No Mapping Found";
    }
    /**
     * Rotta in cui verrà mostrata una lista delle possibili chiamate da effettuare
     * @return Stringa che verrà utilizzata per mostrare una lista delle possibili chiamate da effettuare
     */
    @GetMapping("/")
    public String index(){
        return "index";
    }
}