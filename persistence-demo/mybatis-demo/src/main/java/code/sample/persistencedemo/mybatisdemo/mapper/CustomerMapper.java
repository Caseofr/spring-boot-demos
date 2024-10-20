package code.sample.persistencedemo.mybatisdemo.mapper;

import code.sample.persistencedemo.pojo.entity.Customer;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    List<Customer> findAllCustomers();
}
