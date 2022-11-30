package com.example.slackapptest.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "slack")
public class SlackChannelsProperties {
    private final Map<String, String> channel = new HashMap<>();

    public Map<String, String> getChannel() {
        return channel;
    }

    public boolean containsChannel(String key) {
        return channel.containsKey(key);
    }

    public String getChannelByKey(String key) {
        return channel.get(key);
    }
}
