package com.umberto.gui;


import com.umberto.gui.actions.ActionsClass;

import javax.swing.*;
import java.awt.*;


public class Gui extends JFrame{
    static JButton setnMsg = new JButton("Da Inserire");
    static JButton setKey = new JButton("Da Inserire");
    static JButton loadJson = new JButton("Non Caricati");

    public static JButton getUserInfo() {
        return userInfo;
    }

    static JButton userInfo=new JButton("Info Utenti");

    public static JButton getSetnMsg() {
        return setnMsg;
    }

    public static JButton getSetKey() {
        return setKey;
    }

    public static JButton getLoadJson() {
        return loadJson;
    }

    public static JFrame getFrame() {
        return frame;
    }

    static JFrame frame = new JFrame("Twitter Project");
    public Gui() {


        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.add(new JLabel("Imposta il numero di messaggi da caricare"));
       panel.add(setnMsg);
        panel.add(new JLabel("Imposta una parola chiave da usare nella ricerca"));

        panel.add(setKey);
        panel.add(new JLabel("Stato Dati :"));

        panel.add(loadJson);
        panel.add(new JLabel("\n"));
        panel.add(new JLabel("Visualizza info su: "));
        panel.add(userInfo);
        panel.add(new JLabel("\n"));
        JButton filtTxtForUser = new JButton("Cerca una key secondaria nella history dell'user");
        panel.add(filtTxtForUser);
        JButton filtTxtForAll = new JButton("Cerca una key secondarie globali distinte");
        panel.add(filtTxtForAll);
        JButton filtTxtForAllCombo = new JButton("Cerca una key secondarie globali combinate");
        panel.add(filtTxtForAllCombo);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JButton close = new JButton("Chiudi");
        panel.add(close);


        loadJson.addActionListener(ActionsClass.loadJsonAction);
        setKey.addActionListener(ActionsClass.setKeyAction);
        setnMsg.addActionListener(ActionsClass.setMsgAction);
        userInfo.addActionListener(ActionsClass.openUserGui);
        filtTxtForUser.addActionListener(ActionsClass.filtTextForUserActiion);
        filtTxtForAll.addActionListener(ActionsClass.filtTextForAllActiion);
        filtTxtForAllCombo.addActionListener(ActionsClass.filtTextForAllCombedActiion);
        close.addActionListener(ActionsClass.closeButton);

        panel.setBackground(Color.CYAN);
        frame.setLocation(200,200);
        frame.add(panel);
        frame.setMaximumSize(new Dimension( 415,350));
        frame.setSize(415, 350);

        frame.setVisible(false);
    }
}
