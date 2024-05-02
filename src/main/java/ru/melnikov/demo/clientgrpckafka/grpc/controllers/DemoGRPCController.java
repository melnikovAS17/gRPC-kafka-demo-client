package ru.melnikov.demo.clientgrpckafka.grpc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.melnikov.demo.clientgrpckafka.grpc.service.GRPCDataService;

@RestController
public class DemoGRPCController {

    @Autowired
    private GRPCDataService grpcDataService;

    @RequestMapping("/grpc/send")
    public String printMessage(@RequestParam(name = "message") String message, @RequestParam(name = "uuid") String uuid,
        @RequestParam(name = "name") String name) {
        System.out.println(uuid);
        return grpcDataService.send(message, uuid, name);
    }
}
