package code.sample.persistencedemo.controller;

import code.sample.persistencedemo.entity.Customer;
import code.sample.persistencedemo.mapper.CustomerMapper;
import code.sample.persistencedemo.repository.CustomerRepository;
import code.sample.persistencedemo.service.JooqService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class MyController {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;
    private final JooqService jooqService;

    @GetMapping("/jpa/customers")
    public List<Customer> getCustomersUsingJPA() {
        log.info("Fetching all customers using JPA");
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @GetMapping("/mybatis/customers")
    public List<Customer> getCustomersUsingMyBatis() {
        log.info("Fetching all customers using MyBatis");
        return customerMapper.findAllCustomers();
    }

    @GetMapping("/jooq/customers")
    public List<Customer> getCustomersUsingJOOQ() {
        log.info("Fetching all customers using JOOQ");
        return jooqService.getAllCustomers();
    }
}
