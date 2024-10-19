package code.sample.persistencedemo.mapper;

import code.sample.persistencedemo.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    List<Customer> findAllCustomers();
}
