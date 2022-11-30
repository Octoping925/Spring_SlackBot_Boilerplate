package com.example.slackapp;

import com.example.slackapp.config.SlackChannelsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SlackChannelsProperties.class)
public class SlackAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SlackAppApplication.class, args);
    }

}
