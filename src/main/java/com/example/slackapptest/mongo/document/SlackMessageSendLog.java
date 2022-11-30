package com.example.slackapptest.mongo.document;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("slack_message_send_log")
public class SlackMessageSendLog {
    @Id
    private String _id;
    private SlackMessageType type;
    private String message;
    private LocalDateTime sendTime;

    public SlackMessageSendLog(SlackMessageType type, String message) {
        this.type = type;
        this.message = message;
        this.sendTime = LocalDateTime.now();
    }
}
