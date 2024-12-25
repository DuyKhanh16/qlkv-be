package org.example.qlkv.repository;

import jakarta.persistence.Tuple;
import org.example.qlkv.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Customer findByAbbreviation(String abbreviation);

    Customer findByName(String name);

    Optional<Customer> findByAbbreviationAndName(String abbreviation, String name);

    @Query("SELECT c FROM Customer c INNER JOIN Project p On c.id = p.projectOwnerId WHERE c.id = :id")
    Customer findRelationshipProject(@Param("id") int id);

    @Query("select c.id as id, c.name as name , c.abbreviation as abbreviation from Customer c")
    List<Tuple> getIdAndName();
}
