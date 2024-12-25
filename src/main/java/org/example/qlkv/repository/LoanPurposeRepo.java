package org.example.qlkv.repository;

import jakarta.persistence.Tuple;
import org.example.qlkv.entity.LoanPurpose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanPurposeRepo extends JpaRepository<LoanPurpose, Integer> {
    LoanPurpose findByPurposeName(String purposeName);

    @Query("select p from LoanPurpose p inner join Loan l on p.id=l.purposeId1 where p.id = :id")
    Optional<LoanPurpose> checkLoanDelete(@Param("id") Integer id);

    @Query("select p from LoanPurpose p inner join Drawdown d on p.id=d.purposeId1 where p.id = :id")
    Optional<LoanPurpose> checkDrawDown(@Param("id") Integer id);

    @Query("SELECT lp.id as id,lp.purposeName as purposeName from LoanPurpose lp")
    List<Tuple> getIdAndName();
}
