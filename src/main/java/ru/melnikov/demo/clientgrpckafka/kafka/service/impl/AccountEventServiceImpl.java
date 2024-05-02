package ru.melnikov.demo.clientgrpckafka.kafka.service.impl;


import org.springframework.stereotype.Service;
import ru.melnikov.demo.clientgrpckafka.kafka.entities.NewAccount;
import ru.melnikov.demo.clientgrpckafka.kafka.repo.AccountEventRepo;
import ru.melnikov.demo.gRPCtest.client.NewAccountEvent;


@Service
public class AccountEventServiceImpl {

   private final AccountEventRepo rep;

    public AccountEventServiceImpl(AccountEventRepo rep) {
        this.rep = rep;
    }


    public void saveNewAccount(NewAccountEvent newAccountEvent) {

        NewAccount savedAccount = new NewAccount();
        savedAccount.setUuid(newAccountEvent.getAccountId());
        savedAccount.setName(newAccountEvent.getName());
        savedAccount.setAge(newAccountEvent.getAge());
        savedAccount.setGreetingMessage(newAccountEvent.getGreetingMessage());
        rep.save(savedAccount);
    }
}
