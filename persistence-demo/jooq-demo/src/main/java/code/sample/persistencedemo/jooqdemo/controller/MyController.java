package code.sample.persistencedemo.jooqdemo.controller;

import code.sample.persistencedemo.jooqdemo.service.JooqService;
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

    private final JooqService jooqService;

    @GetMapping("/jooq/customers")
    public List<Customer> getCustomersUsingJOOQ() {
        log.info("Fetching all customers using JOOQ");
        return jooqService.getAllCustomers();
    }
}
