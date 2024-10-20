package code.sample.persistencedemo.mybatisdemo.mapper;

import code.sample.persistencedemo.pojo.entity.Purchase;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurchaseMapper {
    List<Purchase> findAllPurchases();
}
