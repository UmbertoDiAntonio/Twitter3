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
    ActionsClass(){

    }
    public static final ActionListener loadJsonAction = e -> {
       if(!Gui.getLoadJson().getText().equals("Da Inserire")&&!Gui.getSetKey().getText().equals("Da Inserire")) {
           if (!Utils.isJustloaded()) {
               try {Utils.setJustloaded(true);
                   new JsonLoader();
                   Utils.noMultiLoad();
                   Gui.getLoadJson().setText("Dati Caricati");
                   Gui.getInfomessageday().setText(Utils.todayMessage()+"Sono di Oggi");
                   Gui.getInfomessageweek().setText(Utils.weekMessage()+"Sono di Questa Settimana");
                   Gui.getInfomessagemonth().setText(Utils.monthMessage()+"Sono di Questo Mese");
                   Gui.getInfomessageRT().setText(Utils.rtMessage(Utils.getRtCase())+"Sono dei ReTweet");
                   Gui.getInfomessageTag().setText(Utils.rtMessage(Utils.getTagCase())+" Contengono dei Tag");
               } catch (IOException k) {
                   JOptionPane.showMessageDialog(null, "ERRORE, caricamento JSON fallito", Utils.ERROR, JOptionPane.ERROR_MESSAGE);
               }
           }else JOptionPane.showMessageDialog(null,"Dati già Caricati",Utils.ERROR,JOptionPane.ERROR_MESSAGE);

       } else JOptionPane.showMessageDialog(null, "ERRORE, Inserisci i dati necessari", Utils.ERROR, JOptionPane.ERROR_MESSAGE);

       };
    public static final ActionListener setMsgAction = e -> {
        Main.setNMessage(Integer.parseInt(JOptionPane.showInputDialog(null,"Inserisci il numero di post che vuoi esaminare","es:100")));
        Gui.getSetnMsg().setText(""+Main.getnMessage());
    };
    public static final ActionListener setKeyAction = e -> {
        Main.setKey((JOptionPane.showInputDialog(null,"Inserisci la Key che vuoi usare nella ricerca","es:terremoto")));
        Gui.getSetKey().setText(Main.getKey());
    };
    public static final ActionListener openUserGui = e -> {
       if(Gui.getLoadJson().getText().equals("Dati Caricati")) {
           ImageIcon icon = new ImageIcon("");
           String user=(String)JOptionPane.showInputDialog(null, "Scegli l'Utente:",
                   "UserList", JOptionPane.QUESTION_MESSAGE, icon, UserData.getScreenList().toArray(), UserData.getScreenList().get(0));
           for (UserData Utente:UserData.getUserDataList()) {

               if(user.equals(Utente.getScreenName())||user.equals("ALL")){new InfoUser(Utente.getScreenName(),Utente.getCreatedAt(),Utente.getMessage());}
           }
           Gui.getUserInfo().setText(""+user);
       }
       else JOptionPane.showMessageDialog(null,"ERRORE, carica un Json Prima","Errore",JOptionPane.ERROR_MESSAGE);
    };
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
            Utils.standardOutputMessage("outputFTU.txt");
              Utils.saveData("outputFTU.txt",UserData.getUserDataSubList());
        }else Utils.noKeyFoundInMessage();
    };
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
            Utils.standardOutputMessage("outputFTA.txt");
            Utils.saveData("outputFTA.txt",UserData.getUserDataSubList());
        }else Utils.noKeyFoundInMessage();
    };
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
            Utils.standardOutputMessage("outputFTC.txt");
            Utils.saveData("outputFTC.txt",UserData.getUserDataSubList());
        }else Utils.noKeyFoundInMessage();
    };
    public static final ActionListener closeButton = e -> Gui.getFrame().dispose();
}
