package de.laag;

import org.springframework.boot.SpringApplication;

import de.laag.config.BusinessConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CaketasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessConfig.class, args);
    }
}
