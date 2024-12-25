package org.example.qlkv.repository;

import org.example.qlkv.entity.ProjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeProjectRepo extends JpaRepository<ProjectType , Integer> {
    ProjectType findByName(String name);

    ProjectType findByTypeDesc(String typeDesc);

    @Query("Select t from ProjectType t inner join Project p on t.id=p.projectTypeId where t.id = :id")
    Optional<ProjectType> findByProjectTypeRelationProject(int id);

}
