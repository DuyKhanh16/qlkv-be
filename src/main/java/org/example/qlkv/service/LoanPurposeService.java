package org.example.qlkv.service;

import jakarta.persistence.Tuple;
import org.example.qlkv.DTO.response.LoanPrDTO;
import org.example.qlkv.entity.LoanPurpose;
import org.example.qlkv.repository.DrawdownRepo;
import org.example.qlkv.repository.LoanPurposeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoanPurposeService {
    @Autowired
    private LoanPurposeRepo loanPurposeRepo;

    @Autowired
    private DrawdownRepo drawdownRepo;

    public List<LoanPurpose> getAllLoanPurpose() {
        return loanPurposeRepo.findAll();
    }

    public LoanPurpose createNew(LoanPurpose loanPurpose) {
        LoanPurpose loanPurpose1 = loanPurposeRepo.findByPurposeName(loanPurpose.getPurposeName());
        if (loanPurpose1 != null) {
            throw new RuntimeException("Mục đích vay đã tồn tại");
        }
        loanPurpose.setInputedDate(LocalDateTime.now());
        return loanPurposeRepo.save(loanPurpose);
    }

    public List<String> deleteLoanPur (List<Integer> list){
        List<String> listErr=new ArrayList<>();
        for (Integer i : list) {
            Optional<LoanPurpose> checkLoan = loanPurposeRepo.checkLoanDelete(i);
            Optional<LoanPurpose> checkDrawdown =loanPurposeRepo.checkDrawDown(i);
            if(checkLoan.isPresent() ){
                listErr.add(checkLoan.get().getPurposeName());
            }
            if(checkDrawdown.isPresent() ){
                listErr.add(checkDrawdown.get().getPurposeName());
            }
            loanPurposeRepo.deleteById(i);
        }
        return listErr;
    }

    public LoanPurpose updateOne(LoanPurpose loanPurpose) {
        LoanPurpose checkLP = loanPurposeRepo.findByPurposeName(loanPurpose.getPurposeName());
        if (checkLP != null) {
            throw  new RuntimeException(loanPurpose.getPurposeName() +" Đã tồn tại trong hệ thống");
        }
        loanPurpose.setInputedDate(LocalDateTime.now());
        return loanPurposeRepo.save(loanPurpose);
    }

    public List<LoanPrDTO> getSelct (){
        List<Tuple> result= loanPurposeRepo.getIdAndName();
        if(!result.isEmpty()){
            return  result.stream().map(row->new LoanPrDTO(
                    row.get("id", Integer.class),
                    row.get("purposeName",String.class)
            )).collect(Collectors.toList());
        }
        return null;
    }
}
