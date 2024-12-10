package org.example.qlkv.repository;

import org.example.qlkv.entity.ProjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeProjectRepo extends JpaRepository<ProjectType , Integer> {
    ProjectType findByName(String name);
}
