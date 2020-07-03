package com.umberto;

import com.umberto.gui.Gui;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.*;
import java.util.Timer;


@SpringBootApplication
public class Twitter4Application {

	public static void main(String[] args) {
		Utils.setArgsValue(args);
		Utils.setJustloaded(false);
		new Gui();
		while (!Utils.canUseSpringBoot()){
			System.out.println("k");
		}
		SpringApplication.run(Twitter4Application.class, args);
	}

}
