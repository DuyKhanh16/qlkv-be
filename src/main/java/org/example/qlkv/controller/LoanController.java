package org.example.qlkv.controller;

import org.example.qlkv.DTO.ApiResponse;
import org.example.qlkv.DTO.response.LoanResponse;
import org.example.qlkv.entity.Loan;
import org.example.qlkv.exception.Messeger;
import org.example.qlkv.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/loan")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @GetMapping("/list")
    public ResponseEntity<?> getLoanList() {
        List<LoanResponse> list =loanService.getListLoan();
        System.out.println(list);
        return new ResponseEntity<>(
                new ApiResponse<>(Messeger.SUCCESS.getMessage(), list),
                HttpStatus.OK
        );
    }

    @PostMapping("/create-one")
    public ResponseEntity<?> createOneLoan(@RequestBody Loan loan) {
       try{
           loanService.createNewLoan(loan);
           return new ResponseEntity<>(new ApiResponse<>(Messeger.SUCCESS.getMessage(),null), HttpStatus.CREATED);
       }catch (Exception e) {
           return new ResponseEntity<>(new ResponseEntity<>(e.getMessage(),null), HttpStatus.CONFLICT);
       }
    }
}
