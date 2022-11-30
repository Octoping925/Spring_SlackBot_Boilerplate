package com.example.slackapp.config;

import com.slack.api.bolt.App;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackAppConfig {
    @Bean
    public App initSlackApp() {
        App slackApp = new App();
        slackApp.command("/test", (req, ctx) -> ctx.ack(":wave: Hello, Octoping!"));
        return slackApp;
    }
}
