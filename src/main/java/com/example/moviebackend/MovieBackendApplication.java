package com.example.moviebackend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MovieBackendApplication {


    public static void main(String[] args) {
        SpringApplication.run(MovieBackendApplication.class, args);
    }


    @Bean
    CommandLineRunner coucou(){
        return args -> {

        };
    }

}