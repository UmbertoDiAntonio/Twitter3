package com.umberto;


import com.umberto.gui.Gui;

import javax.swing.*;


public class Main {
    static int nMessage = 1;

    public static void setNMessage(int nMessage) {
        if (nMessage <= 0 || nMessage > 100) {
            JOptionPane.showMessageDialog(null, "Errore,Numero Non Consentito, sarà cambiato con 1", "Errore", JOptionPane.ERROR_MESSAGE);
            setNMessage(100);
        }
        Main.nMessage = nMessage;
    }

    public static int getnMessage() {
        return nMessage;
    }

    static String key = "";

    public static void setKey(String key) {
        Main.key = key;
    }

    public static String getKey() {
        return key;
    }

    public static void main(String[] args) {
        Utils.setJustloaded(false);
        new Gui();
    }


}
