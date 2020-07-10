package com.umberto.gui.actions;

import com.umberto.Twitter4Application;
import com.umberto.other.JsonLoader;
import com.umberto.other.Utils;

import com.umberto.gui.Gui;
import com.umberto.controller.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class ActionsClass {
    /**
     * @deprecated
     */
    @Deprecated
    ActionsClass(){    }

    /**
     * Questo Metodo di tipo ActionListener Carica i dati del Json e ne esegue le prime statistiche
     */
    public static final ActionListener loadJsonAction = e -> {
       if(!Gui.getLoadJson().getText().equals("Da Inserire")&&!Gui.getSetKey().getText().equals("Da Inserire")) {
           if (Utils.neverOpened()) {
               try {
                   Utils.setJsonOpened(true);
                   new JsonLoader();
                   Gui.getLoadJson().setText("Attivo");
               } catch (IOException k) {
                   JOptionPane.showMessageDialog(null, "ERRORE, caricamento JSON fallito", Utils.ERROR, JOptionPane.ERROR_MESSAGE);
               }
           }else JOptionPane.showMessageDialog(null,"Dati già Caricati", Utils.ERROR,JOptionPane.ERROR_MESSAGE);
       } else JOptionPane.showMessageDialog(null, "ERRORE, Inserisci i dati necessari", Utils.ERROR, JOptionPane.ERROR_MESSAGE);

       };
    /**
     * Questo Metodo di tipo ActionListener Consente di Impostare il numero di messaggi che vogliamo cercare
     */
    public static final ActionListener setMsgAction = e -> {
        Utils.setNMessage(Integer.parseInt(JOptionPane.showInputDialog(null,"Inserisci il numero di post che vuoi esaminare","es:100")));
        Gui.getSetnMsg().setText(""+ Utils.getnMessage());
    };
    /**
     * Questo Metodo di tipo ActionListener Consente di Impostare la parola chiave da cercare
     */
    public static final ActionListener setKeyAction = e -> {
        Utils.setKey((JOptionPane.showInputDialog(null,"Inserisci la Key che vuoi usare nella ricerca","es:terremoto")));
        Gui.getSetKey().setText(Utils.getKey());
    };
    /**
     * Questo Metodo di tipo ActionListener Stabilisce una connessione con la pagina Git del Progetto
     */
    public static final ActionListener openReadMdPost = e -> {
        try {
            Utils.openWebLink("https://github.com/UmbertoDiAntonio/Twitter3");
        } catch (URISyntaxException | IOException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
        }
    };
    /**
     * Questo Metodo di tipo ActionListener Stabilisce una connessione con la pagina http://localhost8080/ del Progetto
     */
    public static final ActionListener openTutorial = e -> {
        try {
            if(!Gui.getLoadJson().getText().equals("Disattivo"))
                Utils.openWebLink("http://localhost:8080/");
                else JOptionPane.showMessageDialog(null,"Programma non Avviato",Utils.ERROR, JOptionPane.ERROR_MESSAGE);
        } catch (URISyntaxException | IOException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
        }
    };
    /**
     * Questo Metodo di tipo ActionListener Stabilisce una connessione con la pagina http://localhost8080/post del Progetto
     */
    public static final ActionListener openPost = e -> {
        try {
            if(!Gui.getLoadJson().getText().equals("Disattivo"))
                Utils.openWebLink("http://localhost:8080/post");
            else JOptionPane.showMessageDialog(null,"Programma non Avviato",Utils.ERROR, JOptionPane.ERROR_MESSAGE);
        } catch (URISyntaxException | IOException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
        }
    };
    /**
     * Questo Metodo di tipo ActionListener Stabilisce una connessione con la pagina http://localhost8080/post/contains/retweet del Progetto
     */
    public static final ActionListener openPostRet = e -> {
        try {
            if(!Gui.getLoadJson().getText().equals("Disattivo"))
                Utils.openWebLink("http://localhost:8080/post/author/contains/retweet");
            else JOptionPane.showMessageDialog(null,"Programma non Avviato",Utils.ERROR, JOptionPane.ERROR_MESSAGE);
        } catch (URISyntaxException | IOException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
        }
    };
    /**
     * Questo Metodo di tipo ActionListener Stabilisce una connessione con la pagina http://localhost8080/post/contains/years/2020 del Progetto
     */
    public static final ActionListener openPostYears = e -> {
        try {
            if(!Gui.getLoadJson().getText().equals("Disattivo"))
                Utils.openWebLink("http://localhost:8080/post/author/contains/years/2020");
            else JOptionPane.showMessageDialog(null,"Programma non Avviato",Utils.ERROR, JOptionPane.ERROR_MESSAGE);
        } catch (URISyntaxException | IOException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
        }
    };

    /**
     * Questo Metodo di tipo ActionListener Chiude il Programma
     */
    public static final ActionListener closeButton = e -> {
        Gui.getClose().setText("Chiuso");
        Gui.getFrame().dispose();

    };

}
