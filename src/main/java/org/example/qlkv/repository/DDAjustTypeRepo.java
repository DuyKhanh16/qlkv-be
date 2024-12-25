package org.example.qlkv.repository;

import org.example.qlkv.entity.DDAjustType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DDAjustTypeRepo extends JpaRepository<DDAjustType,String> {
}
