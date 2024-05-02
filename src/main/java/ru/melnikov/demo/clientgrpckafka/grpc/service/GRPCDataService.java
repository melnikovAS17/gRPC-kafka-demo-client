package ru.melnikov.demo.clientgrpckafka.grpc.service;

import net.devh.boot.grpc.client.inject.GrpcClient;


import org.springframework.stereotype.Service;
import ru.aston.lab.example.grpc.HandshakeServiceGrpc;
import ru.aston.lab.example.grpc.TestHelloClient;

@Service
public class GRPCDataService extends HandshakeServiceGrpc.HandshakeServiceImplBase {


    @GrpcClient(value = "server-app")
    private HandshakeServiceGrpc.HandshakeServiceBlockingStub stub;


    public String send(String message, String uuid, String name) {
        try {
            TestHelloClient.HandshakeResponse response = this.stub.exchangeMessages(TestHelloClient.HandshakeRequest.newBuilder()
                    .setMessage(message)
                    .setUuid(uuid)
                    .setName(name)
                    .build());
           return response.getMessage();

        }catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }

}
