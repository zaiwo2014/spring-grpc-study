package com.leung.server.grpc.service;

import com.demo.grpc.HelloReply;
import com.demo.grpc.HelloRequest;
import com.demo.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(HelloRequest request,
                         StreamObserver<HelloReply> responseObserver) {

        String msg = "Hello, " + request.getName();

        HelloReply reply = HelloReply.newBuilder()
                .setMessage(msg)
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
