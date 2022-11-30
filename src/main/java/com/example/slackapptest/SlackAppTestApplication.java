package com.example.slackapptest;

import com.example.slackapptest.config.SlackChannelsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(SlackChannelsProperties.class)
public class SlackAppTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SlackAppTestApplication.class, args);
    }

}
