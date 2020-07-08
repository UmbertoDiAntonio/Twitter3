package com.umberto.gui.actions;

import com.umberto.other.JsonLoader;
import com.umberto.other.Utils;

import com.umberto.gui.Gui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class ActionsClass {
    /**
     * @deprecated
     */
    @Deprecated
    ActionsClass(){

    }

    /**
     * Questo Metodo di tipo ActionListener Carica i dati del Json e ne esegue le prime statistiche
     */
    public static final ActionListener loadJsonAction = e -> {
       if(!Gui.getLoadJson().getText().equals("Da Inserire")&&!Gui.getSetKey().getText().equals("Da Inserire")) {
           if (Utils.isJustloaded()) {
               try {
                   Utils.setJustloaded(true);
                   new JsonLoader();
                   Gui.getLoadJson().setText("Dati Caricati");
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

    public static final ActionListener openAllPost = e -> {
        try {
            Utils.openWebLink("http://localhost:8080/post");
        } catch (URISyntaxException | IOException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
        }
    };
    public static final ActionListener openToDayPost = e -> {
        try {
            Utils.openWebLink("http://localhost:8080/post/author/contains/year/month/day/"+Utils.getDayOfMonth());
        } catch (URISyntaxException | IOException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
        }
    };
    public static final ActionListener openTagPost = e -> {
        try {
            Utils.openWebLink("http://localhost:8080/post/author/contains/tag");
        } catch (URISyntaxException | IOException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
        }
    };
    public static final ActionListener openRetweetPost = e -> {
        try {
            Utils.openWebLink("http://localhost:8080/post/author/contains/retweet");
        } catch (URISyntaxException | IOException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
        }
    };
    /**
     * Questo Metodo di tipo ActionListener Chiude il Programma
     */
    public static final ActionListener closeButton = e -> Gui.getFrame().dispose();

}
