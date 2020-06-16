package com.umberto;


import com.umberto.gui.Gui;

import javax.swing.*;

/**
 * <h1>Twitter3</h1>
 * \nIl Programma Twitter3 implementa un applicazione che
 * controlla un flusso di dati e esegue operazioni di filtri
 * e statistiche su di essi
 *
 * @author  Umberto Di Antonio
 * @version 4.0
 * @since   2020-06-16
 */
public class Main {
    static int nMessage = 1;
    /**
     * Questo metodo è usato per impostare un valore intero
     * @param nMessage è usato per contere il numero di messaggi da esaminare.
     */
    public static void setNMessage(int nMessage) {
        if (nMessage <= 0 || nMessage > 100) {
            JOptionPane.showMessageDialog(null, "Errore,Numero Non Consentito, sarà cambiato con 1", "Errore", JOptionPane.ERROR_MESSAGE);
            setNMessage(100);
        }
        Main.nMessage = nMessage;
    }
    /**
     * Questo metodo è usato per restituire un intero
     * @return int This returns a int nMessage.
     */
    public static int getnMessage() {
        return nMessage;
    }

    static String key = "";
    /**
     * Questo metodo è usato per impostare un valore intero
     * @param key è usato per contere una parola chiave da cercare.
     */
    public static void setKey(String key) {
        Main.key = key;
    }
    /**
     * Questo metodo è usato per restituire una String
     * @return String This returns a String Key.
     */
    public static String getKey() {
        return key;
    }
    /**
     * Questo è il metodo principale che utilizza Twitter3
     * @param args Unused.
     */
    public static void main(String[] args) {
        Utils.setJustloaded(false);
        new Gui();
    }


}
