package org.example.qlkv.repository;

import org.example.qlkv.entity.CollateralType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CollateralTypeRepo extends JpaRepository<CollateralType, Integer> {
    CollateralType findByCollateralTypeNo(String collateralTypeNo);

    CollateralType findByCollateralTypeNoAndDescription(String collateralTypeNo, String description);

    CollateralType findByCollateralTypeNoOrDescription(String collateralTypeNo, String description);

    @Query("select t from CollateralType t join Collateral c on t.id=c.collTypeId where t.id = :id ")
    Optional<CollateralType> findTypeRelationCollate(@Param("id") Integer id);
}
