package code.sample.persistencedemo.mybatisdemo.controller;

import code.sample.persistencedemo.mybatisdemo.mapper.CustomerMapper;
import code.sample.persistencedemo.pojo.entity.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/mybatis/customers/{customerName}")
    public ResponseEntity<Object> saveCustomerUsingMyBatis(@PathVariable String customerName) {
        int result = customerMapper.saveCustomer(Customer.builder().name(customerName).build());

        return ResponseEntity.ok("result = " + result);
    }
}
