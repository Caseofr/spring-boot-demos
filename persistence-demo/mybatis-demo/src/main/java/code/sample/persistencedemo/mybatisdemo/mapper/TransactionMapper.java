package code.sample.persistencedemo.mybatisdemo.mapper;

import code.sample.persistencedemo.pojo.entity.Transaction;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransactionMapper {
    List<Transaction> findAllTransactions();
}
