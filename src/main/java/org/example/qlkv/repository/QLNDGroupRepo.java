package org.example.qlkv.repository;

import org.example.qlkv.entity.QLNDGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface QLNDGroupRepo extends JpaRepository<QLNDGroup, UUID> {
}
