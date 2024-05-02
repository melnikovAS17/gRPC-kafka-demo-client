package ru.melnikov.demo.clientgrpckafka.kafka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.melnikov.demo.clientgrpckafka.kafka.entities.NewAccount;

@Repository
public interface AccountEventRepo extends JpaRepository<NewAccount, Long> {

}
