package org.example.qlkv.controller;

import org.example.qlkv.DTO.ApiResponse;
import org.example.qlkv.entity.FeeType;
import org.example.qlkv.exception.Messeger;
import org.example.qlkv.service.FeeTypleService;
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
@RequestMapping("api/feeType")
public class FeeTypeController {
    @Autowired
    private FeeTypleService feeTypleService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllFeeTypes() {
        List<FeeType> list = feeTypleService.getAllFeeTypes();
        return new ResponseEntity<>(
                new ApiResponse<>("Thành công",list),
                HttpStatus.OK
        );
    }

    @PostMapping("create")
    public ResponseEntity<?> createFeeType(@RequestBody  FeeType feeType) {
        try{
            feeTypleService.createNewFee(feeType);
            return new ResponseEntity<>(new ApiResponse<>(Messeger.SUCCESS.getMessage(), null), HttpStatus.CREATED);
        }catch (Exception e) {
            return  new ResponseEntity<>(new ApiResponse<>(e.getMessage(), null), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editFeeType(@RequestBody  FeeType feeType) {
        try{
            feeTypleService.createNewFee(feeType);
            return new ResponseEntity<>(new ApiResponse<>(Messeger.SUCCESS.getMessage(), null), HttpStatus.OK);
        }catch (Exception e) {
            return  new ResponseEntity<>(new ApiResponse<>(e.getMessage(), null), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteFeeType(@RequestBody  List<Integer> listId) {
        List<String> listErr = feeTypleService.deleteFt(listId);
        if(listErr.size()>0) {
            return new ResponseEntity<>(new ApiResponse<>(listErr.toString()+Messeger.DELETE_FAIL.getMessage(), null), HttpStatus.CONFLICT);
        }else return new ResponseEntity<>(new ApiResponse<>(Messeger.SUCCESS.getMessage(), null), HttpStatus.OK);
    }
}
