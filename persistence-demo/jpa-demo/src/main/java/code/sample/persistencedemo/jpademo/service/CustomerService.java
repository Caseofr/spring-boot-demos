package code.sample.persistencedemo.jpademo.service;

import code.sample.persistencedemo.jpademo.repository.CustomerRepository;
import code.sample.persistencedemo.pojo.entity.Customer;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> findCustomers(String name, Long minId) {
        return customerRepository.findAll(
                CustomerSpecification.getCustomerSpecification(name, minId));
    }
}
