package dev.bengi.messageservice.config;

import dev.bengi.interfaceservice.MessageServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for the gRPC client.
 *
 * @author S. Bengi
 */
@Configuration
public class GrpcClientConfig {

    /**
     * Creates a new gRPC channel to the server.
     *
     * @return the newly created channel
     */
    @Bean
    public ManagedChannel channel() {
        return ManagedChannelBuilder
                .forAddress("localhost", 9090) // Replace with the actual server address
                .usePlaintext() // Use plaintext communication (not recommended for production)
                .build();
    }

    /**
     * Creates a new blocking stub for the MessageServiceGrpc service.
     *
     * @param channel the channel to use for communication
     * @return the newly created blocking stub
     */
    @Bean
    public MessageServiceGrpc.MessageServiceBlockingStub blockingStub(ManagedChannel channel) {
        return MessageServiceGrpc.newBlockingStub(channel);
    }
}