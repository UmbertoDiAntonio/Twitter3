package com.umberto.database;

import javax.swing.*;

public class InfoUser {
    public InfoUser(String screenname,String createdAt,String message) {
        JOptionPane.showMessageDialog(null,"Utente: "+screenname+
                "\nData Messaggio: "+createdAt+"\n" +
                "Testo: "+message
        );
    }
}
