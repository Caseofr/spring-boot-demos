package code.sample.persistencedemo.jpademo.repository;

import code.sample.persistencedemo.pojo.entity.Customer;

import lombok.RequiredArgsConstructor;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerJdbcRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<Customer> findCustomers(String name, Long minId) {
        StringBuilder sql = new StringBuilder("SELECT * FROM Customer WHERE 1=1");

        MapSqlParameterSource parameters = new MapSqlParameterSource();

        if (name != null) {
            sql.append(" AND name = :name");
            parameters.addValue("name", name);
        }

        if (minId != null) {
            sql.append(" AND id >= :minId");
            parameters.addValue("minId", minId);
        }

        return jdbcTemplate.query(sql.toString(), parameters, new BeanPropertyRowMapper<>(Customer.class));
    }
}
