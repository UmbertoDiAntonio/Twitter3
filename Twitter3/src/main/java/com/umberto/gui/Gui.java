package com.umberto.gui;


import com.umberto.Utils;
import com.umberto.gui.actions.ActionsClass;

import javax.swing.*;
import java.awt.*;


public class Gui extends JFrame{
    static JButton setnMsg = new JButton("Da Inserire");
    static JButton setKey = new JButton("Da Inserire");
    static JButton loadJson = new JButton("Non Caricati");
    static JLabel infomessageday=new JLabel(Utils.WAITING_DATA);
    static JLabel infomessageweek=new JLabel(Utils.WAITING_DATA);
    static JLabel infomessagemonth=new JLabel(Utils.WAITING_DATA);
    static JLabel infomessageRT=new JLabel(Utils.WAITING_DATA);
    static JLabel infomessageTag=new JLabel(Utils.WAITING_DATA);
    static JButton userInfo=new JButton("Seleziona un Utente");
    static JFrame frame = new JFrame("Twitter Project");

    /**
     * Questo MetodoRestituisce l'oggetto JLabel contenente la Stringa sui Messaggi con Data Oggi
     * @return JLabel: Restituisce l'oggetto JLabel contenente la Stringa sui Messaggi con Data Oggi
     */
    public static JLabel getInfomessageday() {
        return infomessageday;
    }
    /**
     * Questo MetodoRestituisce l'oggetto JLabel contenente la Stringa sui Messaggi di Questa Settiman
     * @return JLabel: Restituisce l'oggetto JLabel contenente la Stringa sui Messaggi di Questa Settimana
     */
    public static JLabel getInfomessageweek() {
        return infomessageweek;
    }
    /**
     * Questo MetodoRestituisce l'oggetto JLabel contenente la Stringa sui Messaggi  di Questo Mese
     * @return JLabel: Restituisce l'oggetto JLabel contenente la Stringa sui Messaggi di Questo Mese
     */
    public static JLabel getInfomessagemonth() {
        return infomessagemonth;
    }
    /**
     * Questo MetodoRestituisce l'oggetto JLabel contenente la Stringa sui Messaggi con ReTweet
     * @return JLabel: Restituisce l'oggetto JLabel contenente la Stringa sui Messaggi con ReTweet
     */
    public static JLabel getInfomessageRT() { return infomessageRT; }
    /**
     * Questo MetodoRestituisce l'oggetto JLabel contenente la Stringa sui Messaggi con Tag
     * @return JLabel: Restituisce l'oggetto JLabel contenente la Stringa sui Messaggi con Tag
     */
    public static JLabel getInfomessageTag() { return infomessageTag; }
    /**
     * Questo MetodoRestituisce l'oggetto JButton userInfo
     * @return JButton: Restituisce l'oggetto JButton userInfo
     */
    public static JButton getUserInfo() {
        return userInfo;
    }
    /**
     * Questo MetodoRestituisce l'oggetto JButton SetnMsg
     * @return JButton: Restituisce l'oggetto JButton SetnMsg
     */
    public static JButton getSetnMsg() {
        return setnMsg;
    }
    /**
     * Questo MetodoRestituisce l'oggetto JButton setKey
     * @return JButton: Restituisce l'oggetto JButton setKey
     */
    public static JButton getSetKey() {
        return setKey;
    }
    /**
     * Questo MetodoRestituisce l'oggetto JButton loadJson
     * @return JButton: Restituisce l'oggetto JButton loadJson
     */
    public static JButton getLoadJson() {
        return loadJson;
    }
    /**
     * Questo MetodoRestituisce l'oggetto JFrame frame
     * @return JButton: Restituisce l'oggetto JFrame frame
     */
    public static JFrame getFrame() {
        return frame;
    }


    /**
     * Questo Metodo Genera un Intefaccia Grafica Contenente tutte le funzioni del Programma
     */
    public Gui() {
        JButton close = new JButton("Chiudi");
        JButton filtTxtForUser = new JButton("Nei Messaggi Dell'User Selezionato");
        JButton filtTxtForAll = new JButton("Nei Messaggi Globali a Key Distinte");
        JButton filtTxtForAllCombo = new JButton("Nei Messaggi Globali a Key Combinate");
        JButton saveAll=new JButton("Salva Senza Applicare Filtri");

        JPanel panelLoad=new JPanel();
        panelLoad.setLayout(new GridLayout(3,2));
        JPanel panelInfo=new JPanel();
        panelInfo.setLayout(new GridLayout(6,2));
        JPanel selectUser=new JPanel();
        selectUser.setLayout(new GridLayout(1,2));
        JPanel panelfilt=new JPanel();
        panelfilt.setLayout(new GridLayout(2,2));

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(new Dimension(530,450));
        frame.setLayout(new GridLayout(7,1,5,5));

        panelLoad.add(new JLabel("Imposta il numero di messaggi "));
        panelLoad.add(setnMsg);
        panelLoad.add(new JLabel("Imposta una parola chiave da cercare"));
        panelLoad.add(setKey);
        panelLoad.add(new JLabel("Stato Dati :"));
        panelLoad.add(loadJson);
        frame.add(panelLoad);

        panelInfo.add(new JLabel("Informazioni sui Dati :"));
        panelInfo.add(new JLabel("\n"));
        panelInfo.add(infomessageday);
        panelInfo.add(infomessageRT);
        panelInfo.add(infomessageweek);
        panelInfo.add(infomessageTag);
        panelInfo.add(infomessagemonth);
        panelInfo.add(new JLabel("\n"));

        frame.add(panelInfo);

        selectUser.add(new JLabel("Visualizza info su: "));
        selectUser.add(userInfo);
        frame.add(selectUser);

        panelfilt.add(filtTxtForUser);
        panelfilt.add(filtTxtForAll);
        panelfilt.add(filtTxtForAllCombo);
        panelfilt.add(saveAll);

        frame.add(new JSeparator());
        frame.add(new JLabel("                                                                                  Filtri"));
        frame.add(panelfilt);
        frame.add(close);

        loadJson.addActionListener(ActionsClass.loadJsonAction);
        setKey.addActionListener(ActionsClass.setKeyAction);
        setnMsg.addActionListener(ActionsClass.setMsgAction);
        userInfo.addActionListener(ActionsClass.openUserGui);
        filtTxtForUser.addActionListener(ActionsClass.filtTextForUserActiion);
        filtTxtForAll.addActionListener(ActionsClass.filtTextForAllActiion);
        filtTxtForAllCombo.addActionListener(ActionsClass.filtTextForAllCombedActiion);
        close.addActionListener(ActionsClass.closeButton);
        saveAll.addActionListener(ActionsClass.saveAllButton);

        frame.setVisible(true);
    }
}
