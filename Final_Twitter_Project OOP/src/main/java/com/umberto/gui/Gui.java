package com.umberto.gui;

import com.umberto.gui.actions.ActionsClass;
import com.umberto.other.Utils;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame{
    static final JButton setnMsg = new JButton("Da Inserire");
    static final JButton setKey = new JButton("Da Inserire");
    static final JButton close = new JButton("Chiudi");
    static final JButton loadJson = new JButton("Disattivo");
    static final JFrame frame = new JFrame("Twitter Project");

    /**
     * Questo MetodoRestituisce l'oggetto JButton Close
     * @return JButton: Restituisce l'oggetto JButton Close
     */
    public static JButton getClose() {
        return close;
    }


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
     * Questo Metodo Genera un Intefaccia Grafica Per Impostare il programma
     */
    public Gui() {
        JButton gitHub= new JButton("Apri GitHub");
        JButton tutorial=new JButton("Apri Rotta \\ (Guida Rotte)");
        JButton post=new JButton("Apri Rotta \\post");
        JButton retwteet=new JButton("Apri Rotta \\post\\author\\contains\\retweet");
        JButton year=new JButton("Apri \\post\\author\\contains\\years\\2020");

        JPanel panelLoad=new JPanel();
        panelLoad.setLayout(new GridLayout(3,2));
        JPanel panelExtra=new JPanel();
        panelExtra.setLayout(new GridLayout(2,2));
        JPanel panelCall=new JPanel();
        panelCall.setLayout(new GridLayout(2,2));

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(new Dimension(480,350));
        frame.setLayout(new GridLayout(3,1,5,5));

        panelLoad.add(new JLabel("Imposta il numero di messaggi "));
        panelLoad.add(setnMsg);
        panelLoad.add(new JLabel("Imposta una parola chiave da cercare"));
        panelLoad.add(setKey);
        panelLoad.add(new JLabel("Stato Programma :"));
        panelLoad.add(loadJson);
        frame.add(panelLoad);

        panelCall.add(tutorial);
        panelCall.add(post);
        panelCall.add(retwteet);
        panelCall.add(year);
        frame.add(panelCall);

        panelExtra.add(new JSeparator());
        panelExtra.add(new JSeparator());
        panelExtra.add(gitHub);
        panelExtra.add(close);
        frame.add(panelExtra);

        loadJson.addActionListener(ActionsClass.loadJsonAction);
        setKey.addActionListener(ActionsClass.setKeyAction);
        setnMsg.addActionListener(ActionsClass.setMsgAction);
        close.addActionListener(ActionsClass.closeButton);
        gitHub.addActionListener(ActionsClass.openReadMdPost);
        tutorial.addActionListener(ActionsClass.openTutorial);
        post.addActionListener(ActionsClass.openPost);
        retwteet.addActionListener(ActionsClass.openPostRet);
        year.addActionListener(ActionsClass.openPostYears);
        if (Utils.getArgsValue().length == 1) {
            setKey.setText("Disattivato: Dati Args");setnMsg.setText("Disattivato: Dati Args");
            setKey.removeActionListener(ActionsClass.setKeyAction);
            setnMsg.removeActionListener(ActionsClass.setMsgAction);
        }


        frame.setVisible(true);
    }
}
