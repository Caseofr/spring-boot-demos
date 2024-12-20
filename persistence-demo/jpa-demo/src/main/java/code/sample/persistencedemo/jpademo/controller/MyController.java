package code.sample.persistencedemo.jpademo.controller;

import code.sample.persistencedemo.jpademo.repository.CustomerRepository;
import code.sample.persistencedemo.pojo.entity.Customer;
import code.sample.persistencedemo.pojo.entity.Transaction;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class MyController {

    private final CustomerRepository customerRepository;

    @GetMapping("/jpa/customers")
    public ResponseEntity<Object> getCustomersUsingJPA() {
        log.info("Fetching all customers using JPA");
        List<Customer> customers = customerRepository.findAll();
        log.info("customers: {}", customers.size());
        fetchTransaction(customers);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/jpa/customers/{id}")
    public ResponseEntity<Object> getCustomersUsingJPA(@PathVariable("id") Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        log.info("1 customer: {}", customer.get().getName());
        fetchTransaction(Collections.singletonList(customer.get()));
        return ResponseEntity.ok().build();
    }

    private void fetchTransaction(final List<Customer> customers) {
        List<Transaction> transactions =
                customers.stream()
                        .flatMap(customer -> customer.getTransactions().stream())
                        .toList();
        log.info("transactions: {}", transactions.size());
    }
}
