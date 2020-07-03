package com.umberto.database;

import javax.swing.*;

/**
 * La Classe InfoUser del programma Twitter3 si occupa
 * di generare una finestra in cui vengono mostrati i dati dell'utente scelto
 */
public class InfoUser {
    /**
     * Questo metodo è usato per mostrare una finestra contenente i dati dell'utente scelto
     * @param screenname contiene lo ScreenName dell'utente scelto.
     * @param message contiene il testo del messaggio dell'utente scelto.
     * @param createdAt contiene la data del messaggio dell'utente scelto.
     */
    public InfoUser(String screenname,String createdAt,String message) {
        JOptionPane.showMessageDialog(null,"Utente: "+screenname+
                "\nData Messaggio: "+createdAt+"\n" +
                "Testo: "+message
        );
    }
}
