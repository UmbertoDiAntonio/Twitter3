package com.umberto;

import com.umberto.gui.Gui;
import com.umberto.other.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * <h1>Twitter3</h1>
 * \nIl Programma Twitter3 implementa un applicazione che
 * controlla un flusso di dati e esegue operazioni di filtri
 * e statistiche su di essi
 *
 * @author Umberto Di Antonio
 * @version 4.0
 * @since 2020-06-16
 */
@SpringBootApplication
public class Twitter4Application {

    public static void main(String[] args) {
        Utils.setArgsValue(args);
        Utils.setJustloaded(false);
        new Gui();
        while (!Utils.canUseSpringBoot()) {
            System.out.println("\b");
        }
        SpringApplication.run(Twitter4Application.class, args);
    }

}
