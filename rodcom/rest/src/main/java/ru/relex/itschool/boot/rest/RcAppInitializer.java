package ru.relex.itschool.boot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : sasha
 */

@SpringBootApplication(scanBasePackages = "ru.relex.itschool")
public class RcAppInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RcAppInitializer.class);
    }

}
