package org.example.qlkv.repository;

import jakarta.persistence.Tuple;
import org.example.qlkv.DTO.response.LoanResponse;
import org.example.qlkv.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepo extends JpaRepository<Loan,Integer> {

    @Query("select l.loanId as loanId , l.contractNo as contractNo ,c1.name as borrOwer , c2.name as lender, c3.name as usedCap , l.contractType as contractType, p.projectName as projectName ,l.loanName as loanName , l.loanAmount as loanAmount ,l.ccy as ccy ,l.interestRate1 as interestRate1 ,l.descriptionInterestRate as descriptionInterestRate , l.fee1 as fee1 , l.fee2 as fee2 , l.fee3 as fee3 ,l.loanPeriod as loanPeriod ,l.fromDate as fromDate , l.endDate as endDate ,l.equityCapital as equityCapital ,l.comment as comment ,u.fullName as mangUser,l.loanStatus as loanStatus from Loan l left join Project p on l.projectId1=p.id left join Customer c1 on l.borrowerId=c1.id left join  Customer c2 on l.lenderId =c2.id left join  Customer  c3 on l.usedCapId=c3.id  left join QLNDUser u on l.mangUser= u.loginName ORDER BY l.loanId DESC")
    List<Tuple> getLoanRelation();

    @Query("select l.loanId as loanId , l.contractNo as contractNo ,c1.name as borrOwer , c2.name as lender, c3.name as usedCap , l.contractType as contractType, p.projectName as projectName ,l.loanName as loanName , l.loanAmount as loanAmount ,l.ccy as ccy ,l.interestRate1 as interestRate1 ,l.descriptionInterestRate as descriptionInterestRate , l.fee1 as fee1 , l.fee2 as fee2 , l.fee3 as fee3 ,l.loanPeriod as loanPeriod ,l.fromDate as fromDate , l.endDate as endDate ,l.equityCapital as equityCapital ,l.comment as comment ,u.fullName as mangUser,l.loanStatus as loanStatus from Loan l left join Project p on l.projectId1=p.id left join Customer c1 on l.borrowerId=c1.id left join  Customer c2 on l.lenderId =c2.id left join  Customer  c3 on l.usedCapId=c3.id left join QLNDUser u on l.mangUser= u.loginName where u.loginName = :loginName ORDER BY l.loanId DESC")
    List<Tuple> getLoanByRoleUser(@Param("loginName") String loginName);

    @Query("select l.loanId as loanId , l.contractNo as contractNo ,c1.name as borrOwer , c2.name as lender, c3.name as usedCap , l.contractType as contractType, p.projectName as projectName ,l.loanName as loanName , l.loanAmount as loanAmount ,l.ccy as ccy ,l.interestRate1 as interestRate1 ,l.descriptionInterestRate as descriptionInterestRate , l.fee1 as fee1 , l.fee2 as fee2 , l.fee3 as fee3 ,l.loanPeriod as loanPeriod ,l.fromDate as fromDate , l.endDate as endDate ,l.equityCapital as equityCapital ,l.comment as comment ,u.fullName as mangUser,l.loanStatus as loanStatus from Loan l left join Project p on l.projectId1=p.id left join Customer c1 on l.borrowerId=c1.id left join  Customer c2 on l.lenderId =c2.id left join  Customer  c3 on l.usedCapId=c3.id left join QLNDUser u on l.mangUser= u.loginName where u.mangUser = :mangUser ORDER BY l.loanId DESC")
    List<Tuple> getLoanByRoleManage(@Param("mangUser") String mangUser);

    Optional<Loan> findByContractNo(String contractNo);

    Loan findByLoanId(int id);

    @Query("select l from Loan l inner join Drawdown d on l.loanId=d.loanId where l.loanId = :id")
    Optional<Loan > findRelationDrawdown(@Param("id") int id);

//    @Modifying
//    @Query("delete from Loan l where l.loanId = :id ")
//    void deleteByLoanIdCustom (@Param("id") int id);

    void deleteByLoanId(Integer i);
}
