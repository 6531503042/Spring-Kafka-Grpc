//package dev.bengi.Kafka;
//
//import dev.bengi.messageservice.service.MessageServiceImpl;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.kafka.core.KafkaTemplate;
//
//@RunWith(MockitoJUnitRunner.class)
//public class KafkaProducerTestWithMockitoJunit {
//
//    private final MessageServiceImpl messageService;
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    public KafkaProducerTestWithMockitoJunit(MessageServiceImpl messageService, KafkaTemplate<String, String> kafkaTemplate) {
//        this.messageService = messageService;
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public void sendMessage() {
//       messageService.sendMessage("message-topic", "test-key", "test-message");
//    }
//
//
//}
