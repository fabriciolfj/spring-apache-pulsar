package com.github.pulser;

import org.apache.pulsar.client.api.DeadLetterPolicy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.pulsar.annotation.EnablePulsar;

@EnablePulsar
@SpringBootApplication
public class PulserApplication {

	static final String USER_DEAD_LETTER_TOPIC = "user-dead-letter-topic";

	public static void main(String[] args) {
		SpringApplication.run(PulserApplication.class, args);
	}

	@Bean
	DeadLetterPolicy deadLetterPolicy() {
		return DeadLetterPolicy.builder()
				.maxRedeliverCount(10)
				.deadLetterTopic(USER_DEAD_LETTER_TOPIC)
				.build();
	}

}
