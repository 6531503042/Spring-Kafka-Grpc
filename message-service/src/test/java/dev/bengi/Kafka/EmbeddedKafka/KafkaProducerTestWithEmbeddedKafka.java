package dev.bengi.Kafka.EmbeddedKafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import dev.bengi.messageservice.MessageServiceApplication;

@SpringBootTest(classes = dev.bengi.messageservice.MessageServiceApplication.class)
@EmbeddedKafka(partitions = 1, topics = { "message-topic" })
public class KafkaProducerTestWithEmbeddedKafka {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void testSendMessage() {
        String key = "test-key";
        String message = "test-message";
        kafkaTemplate.send("message-topic", key, message);
    }
}
