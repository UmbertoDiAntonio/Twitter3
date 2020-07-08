package com.umberto.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class IndexController implements ErrorController{
    private static final String PATH = "/error";
    @Override
    @RequestMapping(PATH)
    @ResponseBody
    public String getErrorPath() {
        return "Error: No Mapping Found";
    }
    /**
     * Rotta in cui verrà restituito il template contenente il frontend dell'applicazione
     * @return Stringa che verrà utilizzata per fare il render del template con il nome corrispondente
     */
    @GetMapping("/")
    public String index(){
        return "index";
    }

}