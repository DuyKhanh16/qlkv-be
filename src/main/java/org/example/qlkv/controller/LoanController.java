package org.example.qlkv.controller;

import org.example.qlkv.DTO.ApiResponse;
import org.example.qlkv.DTO.request.LoanDto;
import org.example.qlkv.DTO.request.LoanExcelDto;
import org.example.qlkv.DTO.response.LoanResponse;
import org.example.qlkv.entity.Loan;
import org.example.qlkv.exception.Messeger;
import org.example.qlkv.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/loan")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @GetMapping("/list")
    public ResponseEntity<?> getLoanList(@Param("role") String role, @Param("userLogin") String userLogin) {
        List<LoanResponse> list =loanService.getListLoan(role,userLogin);
        System.out.println(list);
        return new ResponseEntity<>(
                new ApiResponse<>(Messeger.SUCCESS.getMessage(), list),
                HttpStatus.OK
        );
    }

    @GetMapping("/get-one")
    public ResponseEntity<?> getLoanById(@Param("id") int id) {
        System.out.println(id);
        Loan loan = loanService.getOneLoan(id);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

    @PostMapping("/create-one")
    public ResponseEntity<?> createOneLoan(@RequestBody LoanDto loan) {
       try{
           loanService.createNewLoan(loan);
           return new ResponseEntity<>(new ApiResponse<>(Messeger.SUCCESS.getMessage(),null), HttpStatus.CREATED);
       }catch (Exception e) {
           return new ResponseEntity<>(new ApiResponse<>(e.getMessage(),null), HttpStatus.CONFLICT);
       }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteLoan(@RequestBody List<Integer> listId) {
        List<String> listErr= loanService.deleteListLoan(listId);
        if (!listErr.isEmpty()){
            return new ResponseEntity<>(new ApiResponse<>(listErr.toString() + Messeger.DELETE_FAIL.getMessage() ,null), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(new ApiResponse<>(Messeger.SUCCESS.getMessage(),null), HttpStatus.OK);
    }

    @PostMapping("/import-excel")
    public ResponseEntity<?> importExcelLoan(@RequestBody List<LoanExcelDto> listLoan, @RequestParam("inputedUser") String inputedUser) {
        try{
            loanService.saveLoanExcel(listLoan,inputedUser);
            return new ResponseEntity<>(new ApiResponse<>(Messeger.SUCCESS.getMessage(),null), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse<>(e.getMessage(),null), HttpStatus.CONFLICT);
        }
    }
}
