package com.jux.myhomebook;

import com.jux.myhomebook.Controller.MediaController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MyHomeBookApplication implements CommandLineRunner {

    private final MediaController mediaController;

    public MyHomeBookApplication(MediaController mediaController) {
        this.mediaController = mediaController;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyHomeBookApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(mediaController.getMedias().toString());

    }
}

