package com.github.pulser;

import lombok.RequiredArgsConstructor;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final PulsarProducer producer;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final User user) throws PulsarClientException {
        producer.sendStringMessageToPulsarTopic(user);
    }
}
