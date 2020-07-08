package com.umberto.gui;

import com.umberto.gui.actions.ActionsClass;

import javax.swing.*;
import java.awt.*;


public class Gui extends JFrame{
    static final JButton setnMsg = new JButton("Da Inserire");
    static final JButton setKey = new JButton("Da Inserire");
    static final JButton loadJson = new JButton("Non Caricati");
    static final JFrame frame = new JFrame("Twitter Project");


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
        JButton allPost= new JButton("Tutti i Post");
        JButton dayPost= new JButton("Post Recenti (Oggi)");
        JButton reTweetPost= new JButton("Post con ReTweet");
        JButton tagPost= new JButton("Post con Tag");

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



        frame.add(new JSeparator());
        frame.add(new JLabel("Esempi di Chiamate"));
        panelfilt.add(allPost);
        panelfilt.add(dayPost);
        panelfilt.add(reTweetPost);
        panelfilt.add(tagPost);
        frame.add(panelfilt);
        frame.add(close);

        loadJson.addActionListener(ActionsClass.loadJsonAction);
        setKey.addActionListener(ActionsClass.setKeyAction);
        setnMsg.addActionListener(ActionsClass.setMsgAction);
        close.addActionListener(ActionsClass.closeButton);
        allPost.addActionListener(ActionsClass.openAllPost);
        dayPost.addActionListener(ActionsClass.openToDayPost);
        reTweetPost.addActionListener(ActionsClass.openRetweetPost);
        tagPost.addActionListener(ActionsClass.openTagPost);


        frame.setVisible(true);
    }
}
