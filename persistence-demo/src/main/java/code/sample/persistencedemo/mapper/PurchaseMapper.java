package code.sample.persistencedemo.mapper;

import code.sample.persistencedemo.entity.Purchase;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurchaseMapper {
    List<Purchase> findAllPurchases();
}
