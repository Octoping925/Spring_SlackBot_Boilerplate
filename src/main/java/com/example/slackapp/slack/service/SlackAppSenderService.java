package com.example.slackapp.slack.service;

import com.example.slackapp.mongo.document.SlackMessageSendLog;
import com.example.slackapp.mongo.document.SlackMessageType;
import com.example.slackapp.mongo.service.MongoUploadService;
import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SlackAppSenderService {
    @Value(value = "${slack.token}")
    String token;

    private final MongoUploadService mongoUploadService;

    public void postSlackMessage(String message, String channel) {
        try {
            MethodsClient methods = Slack.getInstance().methods(token);
            ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel(channel)
                .text(message)
                .build();

            methods.chatPostMessage(request);
            mongoUploadService.saveSendLog(new SlackMessageSendLog(SlackMessageType.INFO, message));
        }
        catch (SlackApiException | IOException e) {
            mongoUploadService.saveSendLog(new SlackMessageSendLog(SlackMessageType.ERROR, e.toString()));
            e.printStackTrace();
        }
    }
}
