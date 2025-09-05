package com.kafka.consumer.service;

import com.kafka.consumer.model.Customer;
import com.kafka.consumer.utils.KafkaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService {

    @KafkaListener(topics = KafkaConstants.TOPIC, groupId = KafkaConstants.GROUP_ID)
    public Customer listener(Customer c) {
        System.out.println("**** Msg received from Kafka Topic :: " +c);
        return c;
    }
}
