package org.example.qlkv.repository;

import org.example.qlkv.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Customer findByAbbreviation(String abbreviation);

    Customer findByName(String name);

    Optional<Customer> findByAbbreviationAndName(String abbreviation, String name);
}
