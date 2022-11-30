package com.example.slackapptest.mongo.service;

import com.example.slackapptest.mongo.document.SlackMessageSendLog;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MongoUploadService {
    private final MongoTemplate mongoTemplate;

    public Optional<SlackMessageSendLog> getSendLog(Long id) {
        return Optional.ofNullable(mongoTemplate.findById(id, SlackMessageSendLog.class));
    }

    public void saveSendLog(SlackMessageSendLog slackMessageSendLog) {
        mongoTemplate.save(slackMessageSendLog);
    }
}
