package code.sample.persistencedemo.service;

import code.sample.persistencedemo.entity.Customer;
import code.sample.persistencedemo.entity.Purchase;
import code.sample.persistencedemo.entity.Transaction;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class JooqService {

    private final DSLContext dsl;

    public List<Customer> getAllCustomers() {
        log.debug("Fetching all customers using JOOQ");
        return dsl.select().from("customer").fetchInto(Customer.class);
    }

    public List<Transaction> getAllTransactions() {
        log.debug("Fetching all transactions using JOOQ");
        return dsl.select().from("transaction").fetchInto(Transaction.class);
    }

    public List<Purchase> getAllPurchases() {
        log.debug("Fetching all purchases using JOOQ");
        return dsl.select().from("purchase").fetchInto(Purchase.class);
    }
}
