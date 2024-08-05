package dev.bengi.Kafka.TestBroker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = { "message-topic" })
public class KafkaBrokerTest {

    @Autowired
    private EmbeddedKafkaBroker embeddedKafka;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void testEmbeddedKafkaBroker() {
        // Check if the embedded Kafka broker is running
        assertTrue(embeddedKafka != null, "Embedded Kafka broker should not be null");

        // Ensure the Kafka template can connect to the broker
        String brokerAddress = embeddedKafka.getBrokersAsString();
        assertTrue(brokerAddress.contains("localhost"), "Broker address should contain localhost");

        // Optionally, send a test message to verify broker connectivity
        kafkaTemplate.send("message-topic", "test-key", "test-message");

        // Add further checks as necessary (e.g., consuming messages or verifying topic creation)
    }
}
