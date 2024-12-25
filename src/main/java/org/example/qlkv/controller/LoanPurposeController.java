package org.example.qlkv.controller;

import org.example.qlkv.DTO.ApiResponse;
import org.example.qlkv.DTO.response.LoanPrDTO;
import org.example.qlkv.entity.LoanPurpose;
import org.example.qlkv.exception.Messeger;
import org.example.qlkv.service.LoanPurposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/loanPurpose")
public class LoanPurposeController {
    @Autowired
    private LoanPurposeService loanPurposeService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllLoanPurpose() {
        List<LoanPurpose>  list = loanPurposeService.getAllLoanPurpose();
        return new ResponseEntity<>(
                new ApiResponse<>("Thành công",list),
                HttpStatus.OK
        );
    }

    @PostMapping("/create-one")
    public ResponseEntity<?> createLoanPurpose(@RequestBody LoanPurpose loanPurpose) {
        try{
            loanPurposeService.createNew(loanPurpose);
            return new ResponseEntity<>(
                    new ApiResponse<>("Thành công",null),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ApiResponse<>(e.getMessage(),null),
                    HttpStatus.CONFLICT
            );
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteLoanPurpose(@RequestBody List<Integer> listId) {
        List<String> listErr = loanPurposeService.deleteLoanPur(listId);
        if (listErr.isEmpty()) {
            return new ResponseEntity<>(
                    new ApiResponse<>("Thành công",null),
                    HttpStatus.OK
            );
        }else {
            return new ResponseEntity<>(
                    new ApiResponse<>(listErr.toString()+" không thể xóa",null),
                    HttpStatus.CONFLICT
            );
        }
    }

    @PostMapping("/update-one")
    public ResponseEntity<?> updateLoanPurpose(@RequestBody LoanPurpose loanPurpose) {
        try{
            loanPurposeService.updateOne(loanPurpose);
           return  new ResponseEntity<>(
                    new ApiResponse<>("Thành công",null),
                    HttpStatus.OK
            );
        }catch (Exception e){
         return    new ResponseEntity<>(
                    new ApiResponse<>(e.getMessage(),null),
                    HttpStatus.CONFLICT
            );
        }
    }

    @GetMapping("/list-select")
    public ResponseEntity<?> getLoanPurposeSelect() {
        List<LoanPrDTO> list = loanPurposeService.getSelct();
        return new ResponseEntity<>(new ApiResponse<>(Messeger.SUCCESS.getMessage(), list),HttpStatus.OK);
    }
}
