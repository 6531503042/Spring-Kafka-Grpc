package dev.bengi.messageservice.controller;

import dev.bengi.interfaceservice.MessageServiceGrpc;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageServiceGrpc.MessageServiceBlockingStub blockingStub;

    public MessageController(MessageServiceGrpc.MessageServiceBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
    }
}
