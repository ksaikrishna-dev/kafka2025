package com.kafka.producer.service;

import com.kafka.producer.model.Customer;
import com.kafka.producer.utils.KafkaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService {
    @Autowired
    private KafkaTemplate<String, Customer> kafkaTemplate;

    public String add(List<Customer> customers) {
        if(!customers.isEmpty()) {
            for(Customer c : customers) {
                kafkaTemplate.send(KafkaConstants.TOPIC, c);
                System.out.println("******** Msg published to Kafka topic ********");
            }
        }
        return "Customer Record Added To Kafka Queue Successfully...!!";
    }
}
