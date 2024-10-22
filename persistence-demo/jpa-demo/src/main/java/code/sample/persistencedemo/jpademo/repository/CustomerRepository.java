package code.sample.persistencedemo.jpademo.repository;

import code.sample.persistencedemo.pojo.entity.Customer;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;




/**
* some solutions for N+1 problems
*/
@Repository
public interface CustomerRepository
        extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.transactions")
    List<Customer> findAllWithTransactions();

    @EntityGraph(attributePaths = {"transactions"})
    Optional<Customer> findById(@NonNull Long customerId);

    @EntityGraph(attributePaths = {"transactions"})
    List<Customer> findAll();

    // it looks like "DTO projection" doesn't work for nested DTO, e.g. Customer(id, name,
    // List<Transaction>)
    //    @Query("SELECT new code.sample.persistencedemo.pojo.dto.CustomerDTO(c.id, c.name) " +
    //        "FROM Customer c LEFT JOIN c.transactions t")
    //    List<CustomerDTO> findAllWithTransactions2();
}
