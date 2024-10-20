package code.sample.persistencedemo.mybatisdemo.controller;

import code.sample.persistencedemo.pojo.entity.Customer;
import code.sample.persistencedemo.mybatisdemo.mapper.CustomerMapper;

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

    private final CustomerMapper customerMapper;

    @GetMapping("/mybatis/customers")
    public List<Customer> getCustomersUsingMyBatis() {
        log.info("Fetching all customers using MyBatis");
        return customerMapper.findAllCustomers();
    }
}
