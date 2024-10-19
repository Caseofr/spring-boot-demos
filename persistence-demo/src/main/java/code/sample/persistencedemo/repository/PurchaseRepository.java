package code.sample.persistencedemo.repository;

import code.sample.persistencedemo.entity.Purchase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {}
