package com.digitalinnovationone.SpringbootConfig.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {
    private String driveClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String testDatabaseConnection(){

        System.out.println("DB conection for DEV - h2");
        System.out.println(driveClassName);
        System.out.println(url);
        return "DB Connection to H2_TEST - Test instance";


    }

    @Profile("Prod")
    @Bean
    public String productionDatabaseConnection(){

        System.out.println("DB conection for Production - MySQL");
        System.out.println(driveClassName);
        System.out.println(url);
        return "DB Connection to MYSQL_PROD - Production instance";


    }




}
