package org.example.qlkv.service;

import org.example.qlkv.entity.FeeType;
import org.example.qlkv.exception.Messeger;
import org.example.qlkv.repository.FeeTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeeTypleService {
    @Autowired
    private FeeTypeRepo feeTypeRepo;

    public List<FeeType> getAllFeeTypes() {
        return feeTypeRepo.findAll();
    };

    public FeeType createNewFee(FeeType feeTypeRq) {
        FeeType checkFt =feeTypeRepo.findByDescription(feeTypeRq.getDescription());
        if (checkFt != null) {
            throw  new RuntimeException(feeTypeRq.getDescription() + Messeger.CONFLICT.getMessage());
        }
        feeTypeRq.setInputedDate(LocalDate.now());
        return feeTypeRepo.save(feeTypeRq);
    }

    public List<String> deleteFt (List<Integer> listId){
        System.out.println(listId);
        List<String> list = new ArrayList<>();
        for (Integer i : listId) {
            Optional<FeeType> ft = feeTypeRepo.relationFeeRepaymen(i);
            if (ft.isPresent()) {
                list.add(ft.get().getDescription());
            }
            feeTypeRepo.deleteById(i);
        }

        return list;
    }
}
