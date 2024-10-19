package code.sample.persistencedemo.jpademo.controller;

import code.sample.persistencedemo.jpademo.repository.CustomerRepository;
import code.sample.persistencedemo.pojo.entity.Customer;

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

    @GetMapping("/jpa/customers")
    public List<Customer> getCustomersUsingJPA() {
        log.info("Fetching all customers using JPA");
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }
}
