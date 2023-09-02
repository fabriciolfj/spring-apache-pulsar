package com.github.pulser;

import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.SubscriptionType;
import org.apache.pulsar.common.schema.SchemaType;
import org.springframework.pulsar.annotation.PulsarListener;
import org.springframework.stereotype.Component;

import static com.github.pulser.PulsarProducer.STRING_TOPIC;
import static com.github.pulser.PulserApplication.USER_DEAD_LETTER_TOPIC;

@Component
@Slf4j
public class PulsarConsumer {

    @PulsarListener(
            subscriptionName = "user-topic-subscription",
            topics = STRING_TOPIC,
            subscriptionType = SubscriptionType.Shared,
            schemaType = SchemaType.JSON,
            deadLetterPolicy = "deadLetterPolicy"
    )
    public void userTopicListener(User user) {
        log.info("Received user object with email: {}", user.getEmail());
    }


    @PulsarListener(
            subscriptionName = "dead-letter-topic-subscription",
            topics = USER_DEAD_LETTER_TOPIC,
            subscriptionType = SubscriptionType.Shared
    )
    public void userDlqTopicListener(User user) {
        log.info("Received user object in user-DLQ with email: {}", user.getEmail());
    }
}
