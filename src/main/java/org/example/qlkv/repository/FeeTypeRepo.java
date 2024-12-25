package org.example.qlkv.repository;

import org.example.qlkv.entity.FeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeeTypeRepo extends JpaRepository<FeeType, Integer> {
    FeeType findByDescription(String description);

    @Query("select f from FeeType f join Feepayment p on f.id=p.feeTypeId where f.id= :i")
    Optional<FeeType> relationFeeRepaymen(@Param("i") Integer i);
}
