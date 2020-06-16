package com.umberto.gui.actions;

import com.umberto.JsonLoader;
import com.umberto.Main;
import com.umberto.Utils;
import com.umberto.database.UserData;
import com.umberto.database.InfoUser;
import com.umberto.gui.Gui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActionsClass {
    /**
     * @deprecated
     */
    ActionsClass(){

    }

    /**
     * Questo Metodo di tipo ActionListener Carica i dati del Json e ne esegue le prime statistiche
     */
    public static final ActionListener loadJsonAction = e -> {
       if(!Gui.getLoadJson().getText().equals("Da Inserire")&&!Gui.getSetKey().getText().equals("Da Inserire")) {
           if (!Utils.isJustloaded()) {
               try {Utils.setJustloaded(true);
                   new JsonLoader();
                   Gui.getLoadJson().setText("Dati Caricati");
                   Gui.getInfomessageday().setText(" "+Utils.todayMessage()+"Sono di Oggi");
                   Gui.getInfomessageweek().setText(" "+Utils.weekMessage()+"Sono di Questa Settimana");
                   Gui.getInfomessagemonth().setText(" "+Utils.monthMessage()+"Sono di Questo Mese");
                   Gui.getInfomessageRT().setText(" "+Utils.rtMessage(Utils.getRtCase())+"Sono dei ReTweet");
                   Utils.nullifyRtCont();
                   Gui.getInfomessageTag().setText(" "+Utils.rtMessage(Utils.getTagCase())+" Contengono dei Tag");
               } catch (IOException k) {
                   JOptionPane.showMessageDialog(null, "ERRORE, caricamento JSON fallito", Utils.ERROR, JOptionPane.ERROR_MESSAGE);
               }
           }else JOptionPane.showMessageDialog(null,"Dati già Caricati",Utils.ERROR,JOptionPane.ERROR_MESSAGE);

       } else JOptionPane.showMessageDialog(null, "ERRORE, Inserisci i dati necessari", Utils.ERROR, JOptionPane.ERROR_MESSAGE);

       };
    /**
     * Questo Metodo di tipo ActionListener Consente di Impostare il numero di messaggi che vogliamo cercare
     */
    public static final ActionListener setMsgAction = e -> {
        Main.setNMessage(Integer.parseInt(JOptionPane.showInputDialog(null,"Inserisci il numero di post che vuoi esaminare","es:100")));
        Gui.getSetnMsg().setText(""+Main.getnMessage());
    };
    /**
     * Questo Metodo di tipo ActionListener Consente di Impostare la parola chiave da cercare
     */
    public static final ActionListener setKeyAction = e -> {
        Main.setKey((JOptionPane.showInputDialog(null,"Inserisci la Key che vuoi usare nella ricerca","es:terremoto")));
        Gui.getSetKey().setText(Main.getKey());
    };
    /**
     * Questo Metodo di tipo ActionListener Consente di Selezionare un utente di cui vengono poi mostrati i dati in una finestra
     */
    public static final ActionListener openUserGui = e -> {
       if(Gui.getLoadJson().getText().equals("Dati Caricati")) {
           ImageIcon icon = new ImageIcon("");
           String user=(String)JOptionPane.showInputDialog(null, "Scegli l'Utente:",
                   "UserList", JOptionPane.QUESTION_MESSAGE, icon, UserData.getScreenList().toArray(), UserData.getScreenList().get(0));
           for (UserData Utente:UserData.getUserDataList()) {

               if(user.equals(Utente.getScreenName())){new InfoUser(Utente.getScreenName(),Utente.getCreatedAt(),Utente.getMessage());}
           }
           Gui.getUserInfo().setText(""+user);
       }
       else JOptionPane.showMessageDialog(null,"ERRORE, carica un Json Prima","Errore",JOptionPane.ERROR_MESSAGE);
    };
    /**
     * Questo Metodo di tipo ActionListener Esegue la ricerca di una seconda parola chiave tra i messaggi dell'utente selezionato e li salva
     */
    public static final ActionListener filtTextForUserActiion = e -> {
        Utils.nullifyContAzioni();
        int clock=0;
        Utils.nullifyRtCont();
        String secondaryKey=(JOptionPane.showInputDialog(null,"Inserisci la Key che vuoi usare nella sub-Ricerca sull'utente "
                +Gui.getUserInfo().getText().trim(),"es:terremoto"));
        for (UserData utente:UserData.getUserDataList()) {
            if(utente.getScreenName().equals(Gui.getUserInfo().getText().trim()) && utente.getMessage().contains(secondaryKey)){
                UserData.getUserDataSubList().add(UserData.getUserDataList().get(clock));
                Utils.contRegUses(Utils.getRtCase(),utente.getMessage());
                Utils.contatoreAzioni();
            }
            clock++;
        }
        if(Utils.getContAzioni()!=0){
            Utils.standardOutputMessage("outputFTU.json");
            Utils.saveData("outputFTU.json",UserData.getUserDataSubList());
        }else Utils.noKeyFoundInMessage();
    };
    /**
     * Questo Metodo di tipo ActionListener Esegue la ricerca di n parole chiave tra i messaggi di tutti gli utenti e salva il messaggio se contiene almeno 1 delle parole chiave
     */
    public static final ActionListener filtTextForAllActiion = e -> {
        Utils.nullifyContAzioni();
        int clock=0;
        Utils.nullifyRtCont();
        boolean sign;
        String secondaryKey=(JOptionPane.showInputDialog(null,"Inserisci le Key che vuoi usare nella sub-Ricerca globale, separale con una virgloa ","es:terremoto,italia,2016"));
        String[] subStrings=Utils.divideString(secondaryKey);
        for (UserData utente:UserData.getUserDataList()) {
            sign=false;
            for (String subString : subStrings) {
                if (utente.getMessage().contains(subString) && !sign) {
                    UserData.getUserDataSubList().add(UserData.getUserDataList().get(clock));
                    Utils.contRegUses(Utils.getRtCase(),utente.getMessage());
                    Utils.contatoreAzioni();
                    sign = true;
                }
            }
            clock++;
        }
        if(Utils.getContAzioni()!=0){
            Utils.standardOutputMessage("outputFTA.json");
            Utils.saveData("outputFTA.json",UserData.getUserDataSubList());
        }else Utils.noKeyFoundInMessage();
    };
    /**
     * Questo Metodo di tipo ActionListener Esegue la ricerca di n parole chiave tra i messaggi dell'utente selezionato e salva il messaggio se contiene almeno tutte le parola chiave
     */
    public static final ActionListener filtTextForAllCombedActiion = e -> {
       Utils.nullifyContAzioni();
        int clock=0;
        Utils.nullifyRtCont();
        int sign;
        String secondaryKey=(JOptionPane.showInputDialog(null,"Inserisci le Key che vuoi usare nella sub-Ricerca globale combinate, separale con una virgloa ","es:terremoto,italia,2016"));
        String[] subStrings=Utils.divideString(secondaryKey);
        for (UserData utente:UserData.getUserDataList()) {
            sign=0;
            for (String subString : subStrings) {
                if (utente.getMessage().contains(subString)) {
                    sign += 1;
                    if(sign==subStrings.length) {UserData.getUserDataSubList().add(UserData.getUserDataList().get(clock));
                        Utils.contRegUses(Utils.getRtCase(),utente.getMessage());
                      Utils.contatoreAzioni();
                    }
                }
            }
            clock++;
        }
        if(Utils.getContAzioni()!=0){
            Utils.standardOutputMessage("outputFTC.json");
            Utils.saveData("outputFTC.json",UserData.getUserDataSubList());
        }else Utils.noKeyFoundInMessage();
    };
    /**
     * Questo Metodo di tipo ActionListener Chiude il Programma
     */
    public static final ActionListener closeButton = e -> Gui.getFrame().dispose();

    /**
     * Questo Metodo di tipo ActionListener Salva il JSon senza Filtri
     */
    public static final ActionListener saveAllButton = e -> {
        Utils.standardOutputMessage("Json.json");
        Utils.saveData("Json.json", UserData.getUserDataList());
    };
}
