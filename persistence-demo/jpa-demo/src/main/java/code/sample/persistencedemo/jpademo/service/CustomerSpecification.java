package code.sample.persistencedemo.jpademo.service;

import code.sample.persistencedemo.pojo.entity.Customer;

import jakarta.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerSpecification {

    public static Specification<Customer> getCustomerSpecification(String name, Long minId) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null) {
                predicates.add(criteriaBuilder.equal(root.get("name"), name));
            }

            if (minId != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("id"), minId));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
