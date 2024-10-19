package code.sample.persistencedemo.jpademo.repository;

import code.sample.persistencedemo.pojo.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {}
