package code.sample.persistencedemo.jpademo.controller;

import code.sample.persistencedemo.jpademo.repository.CustomerJdbcRepository;
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
@RequestMapping("/api2")
public class DynamicQueryController {

    private final CustomerJdbcRepository customerJdbcRepository;

    @GetMapping("/jpa/customers")
    public ResponseEntity<Object> getCustomersUsingJPA() {
        log.info("Fetching all customers using JPA");
        List<Customer> customers = customerJdbcRepository.findCustomers(null, 0L);
        log.info("customers: {}", customers.size());
//        fetchTransaction(customers);
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
