package org.example.qlkv.service;

import jakarta.persistence.Tuple;
import org.example.qlkv.DTO.response.LoanResponse;
import org.example.qlkv.entity.Loan;
import org.example.qlkv.exception.Messeger;
import org.example.qlkv.repository.LoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoanService {
    @Autowired
    private LoanRepo loanRepo;

    public List<LoanResponse> getListLoan(){

        List<Tuple> listTup =loanRepo.getLoanRelation();
        if(!listTup.isEmpty()){
            return  listTup.stream().map(row->new LoanResponse(
                            row.get("loanId", Integer.class),
                            row.get("contractNo", String.class),
                            row.get("borrOwer", String.class),
                            row.get("lender", String.class),
                            row.get("usedCap", String.class),
                            row.get("contractType", String.class),
                            row.get("projectName", String.class),
                            row.get("loanName", String.class),
                            row.get("loanAmount", BigDecimal.class),
                            row.get("ccy", String.class),
                            row.get("interestRate1", BigDecimal.class),
                            row.get("descriptionInterestRate", String.class),
                            row.get("fee1", BigDecimal.class),
                            row.get("fee2", BigDecimal.class),
                            row.get("fee3", BigDecimal.class),
                            row.get("loanPeriod", String.class),
                            row.get("fromDate", LocalDateTime.class),
                            row.get("endDate", LocalDateTime.class),
                            row.get("equityCapital", BigDecimal.class),
                            row.get("comment", String.class),
                            row.get("mangUser", String.class),
                            row.get("loanStatus", String.class)
                    ))
                    .collect(Collectors.toList());
        }

        return Collections.emptyList(); // Return empty list if result is empty

    }

    public Loan createNewLoan (Loan loan){
        Optional<Loan> loanOptional = loanRepo.findByContractNo(loan.getContractNo());
        if(loanOptional.isPresent()){
            throw new RuntimeException(Messeger.CONFLICT.getMessage());
        }
        return loanRepo.save(loan);
    };
}
