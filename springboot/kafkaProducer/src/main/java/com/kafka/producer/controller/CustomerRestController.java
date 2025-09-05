package com.kafka.producer.controller;

import com.kafka.producer.model.Customer;
import com.kafka.producer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kafka")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addcustomers")
    public String addCustomer(@RequestBody List<Customer> customers) {
        return customerService.add(customers);
    }
}
