package com.example.slackapp.common;

import com.example.slackapp.config.SlackChannelsProperties;

public class Validator {
    public static boolean isValidSlackMessage(String text) {
        return text != null && text.length() > 0;
    }

    public static boolean isValidSlackChannel(String channel, SlackChannelsProperties properties) {
        return channel != null && properties.containsChannel(channel);
    }
}
