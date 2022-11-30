package com.example.slackapptest.slack.controller;

import com.example.slackapptest.common.Validator;
import com.example.slackapptest.config.SlackChannelsProperties;
import com.example.slackapptest.slack.service.SlackAppSenderService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SlackAppController {
    private final SlackAppSenderService slackAppSenderService;
    private final SlackChannelsProperties slackChannelsProperties;

    @GetMapping("/slack/sendMessage")
    public ResponseEntity<String> sendMessage(HttpServletRequest req) {
        String message = req.getParameter("message");
        String channel = req.getParameter("channel");

        if(!Validator.isValidSlackMessage(message)) {
            return ResponseEntity.badRequest().body("Invalid message");
        }
        if(!Validator.isValidSlackChannel(channel, slackChannelsProperties)) {
            return ResponseEntity.badRequest().body("Invalid channel");
        }

        slackAppSenderService.postSlackMessage(message, slackChannelsProperties.getChannelByKey(channel));
        return ResponseEntity.ok().body("Slack message sent");
    }

}
