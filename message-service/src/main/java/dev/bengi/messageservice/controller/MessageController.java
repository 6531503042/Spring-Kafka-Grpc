package dev.bengi.messageservice.controller;

import dev.bengi.interfaceservice.MessageRequest;
import dev.bengi.interfaceservice.MessageServiceGrpc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Controller for GRPC Service, Kafka and gRPC client
 * @Author S. Bengi
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageServiceGrpc.MessageServiceBlockingStub messageServiceStub;

    public MessageController(MessageServiceGrpc.MessageServiceBlockingStub messageServiceStub) {
        this.messageServiceStub = messageServiceStub;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        // Create the gRPC request
        MessageRequest request = MessageRequest.newBuilder()
                .setMessage(message)
                .build();

        // Call the gRPC service
        String responseMessage = messageServiceStub.getMessage(request).getMessage();

        // Return the response message
        return responseMessage;
    }
}
