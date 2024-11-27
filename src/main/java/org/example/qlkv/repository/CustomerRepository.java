package org.example.qlkv.repository;

import org.example.qlkv.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Override
    List<Customer> findAll();
}
