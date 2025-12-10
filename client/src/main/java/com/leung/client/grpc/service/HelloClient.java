package com.leung.client.grpc.service;

import com.demo.grpc.HelloReply;
import com.demo.grpc.HelloRequest;
import com.demo.grpc.HelloServiceGrpc;
import org.springframework.stereotype.Service;

@Service
public class HelloClient {

    private final HelloServiceGrpc.HelloServiceBlockingStub helloStub;

    public HelloClient(HelloServiceGrpc.HelloServiceBlockingStub helloStub) {
        this.helloStub = helloStub;
    }

    public String sayHello(String name) {
        HelloRequest req = HelloRequest.newBuilder().setName(name).build();
        HelloReply reply = helloStub.sayHello(req);
        return reply.getMessage();
    }
}
