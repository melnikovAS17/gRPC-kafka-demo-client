package ru.melnikov.demo.clientgrpckafka.kafka.entities;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "new_account")
public class NewAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    @Setter(AccessLevel.NONE)
    private Long accountId;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "name")
    private String Name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "greeting_message")
    private String greetingMessage;
}
