package ru.melnikov.demo.clientgrpckafka.kafka.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import ru.melnikov.demo.clientgrpckafka.kafka.service.impl.AccountEventServiceImpl;
import ru.melnikov.demo.gRPCtest.client.NewAccountEvent;

@Service
// @KafkaListener("product-list") - можно поставить здесь в таком случае над методом (ниже)
public class NewAccountEventHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AccountEventServiceImpl accountEventServiceImpl;

    public NewAccountEventHandler(AccountEventServiceImpl accountEventServiceImpl) {

        this.accountEventServiceImpl = accountEventServiceImpl;
    }

    @KafkaListener(topics = "account-list", groupId = "${spring.kafka.consumer.group-id}")
    // @KafkaHandler - будет слушать ивенты по аргументам, которые передаём в метод
    public void listen(NewAccountEvent accountEvent) {
        logger.info(" account event: {}", accountEvent.getName());
        accountEventServiceImpl.saveNewAccount(accountEvent);

    }
}
