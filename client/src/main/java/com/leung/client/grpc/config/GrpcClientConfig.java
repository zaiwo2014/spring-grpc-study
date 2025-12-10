package com.leung.client.grpc.config;

import com.demo.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfig {

    @Bean
    public ManagedChannel helloChannel() {
        return ManagedChannelBuilder
                .forAddress("localhost", 9090)
                .usePlaintext()
                .build();
    }

    @Bean
    public HelloServiceGrpc.HelloServiceBlockingStub helloBlockingStub(ManagedChannel helloChannel) {
        return HelloServiceGrpc.newBlockingStub(helloChannel);
    }

    @Bean
    public HelloServiceGrpc.HelloServiceStub helloAsyncStub(ManagedChannel helloChannel) {
        return HelloServiceGrpc.newStub(helloChannel);
    }
}
