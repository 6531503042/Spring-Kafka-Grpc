package dev.bengi.messageservice.service;

import dev.bengi.interfaceservice.MessageRequest;
import dev.bengi.interfaceservice.MessageResponse;
import dev.bengi.interfaceservice.MessageServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
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
     * Handles incoming messages and responds back.
     *
     * @param request The message request containing the message.
     * @param responseObserver The observer for sending the response.
     */
    @Override
    public void message(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
        String message = request.getMessage();
        System.out.println("Received Message: " + message);

        // Create a response with the received message
        MessageResponse response = MessageResponse.newBuilder()
                .setMessage(message)
                .build();

        // Send the response to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}