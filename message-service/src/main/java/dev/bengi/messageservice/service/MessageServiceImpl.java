package dev.bengi.messageservice.service;

import dev.bengi.interfaceservice.MessageRequest;
import dev.bengi.interfaceservice.MessageResponse;
import dev.bengi.interfaceservice.MessageServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Service implementation for handling messages.
 * This class extends the generated gRPC service base class.
 * Handles receiving and responding to messages.
 *
 * @author bengi
 */
@GrpcService
@Service
public class MessageServiceImpl extends MessageServiceGrpc.MessageServiceImplBase {

    /**
     * Constructor for the service.
     *
     * @param kafkaTemplate The Kafka template for sending messages.
     * Using Injection constructor bean for testing
     */
    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Handles incoming messages and responds back.
     *
     * @param request The message request containing the message.
     * @param responseObserver The observer for sending the response.
     * This is used to send the response back to the client.
     */
    @Override
    public void getMessage(MessageRequest request, io.grpc.stub.StreamObserver<MessageResponse> responseObserver) {

        // Send message to Kafka
        String message = request.getMessage();
        kafkaTemplate.send("message-topic", message);

        // Create a response with the received message
        MessageResponse response = MessageResponse.newBuilder()
                .setMessage("Message sent to Kafka: " + message)
                .build();

        // Send the response to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}