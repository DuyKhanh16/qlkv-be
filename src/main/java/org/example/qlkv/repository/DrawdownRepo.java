package org.example.qlkv.repository;

import org.example.qlkv.entity.Drawdown;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrawdownRepo extends JpaRepository<Drawdown, Integer> {
}
