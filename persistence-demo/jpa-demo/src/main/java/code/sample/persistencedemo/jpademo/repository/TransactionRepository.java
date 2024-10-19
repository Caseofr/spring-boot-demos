package code.sample.persistencedemo.jpademo.repository;

import code.sample.persistencedemo.pojo.entity.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
