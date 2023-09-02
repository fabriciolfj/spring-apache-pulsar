package com.github.pulser;

import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Component;

@Component
public class PulsarProducer {

    @Autowired
    private PulsarTemplate<User> stringTemplate;

    static final String STRING_TOPIC = "string-topic";

    public void sendStringMessageToPulsarTopic(final User value) throws PulsarClientException {
        stringTemplate.send(STRING_TOPIC, value);
    }
}
