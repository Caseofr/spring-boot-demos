package code.sample.persistencedemo.mapper;

import code.sample.persistencedemo.entity.Transaction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransactionMapper {
    List<Transaction> findAllTransactions();
}
