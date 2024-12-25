package org.example.qlkv.controller;

import org.example.qlkv.DTO.ApiResponse;
import org.example.qlkv.entity.CollateralType;
import org.example.qlkv.exception.Messeger;
import org.example.qlkv.service.CollateralTypeService;
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
@RequestMapping("api/collateralType")
public class CollateralTypeController {

    @Autowired
    private CollateralTypeService collateralTypeService;

    @GetMapping("/list")
    public ResponseEntity<?> getCollateralTypeList() {
        List<CollateralType> list = collateralTypeService.getAllCollateralTypes();
        return new ResponseEntity<>(
                new ApiResponse<>("Thành công", list),
                HttpStatus.OK
        );
    }

    @PostMapping("/create-one")
    public ResponseEntity<?> createCollateralType(@RequestBody CollateralType collateralType) {
        try{
            collateralTypeService.createNew(collateralType);
            return new ResponseEntity<>(new ApiResponse<>("Thành công",null), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse<>(e.getMessage(), null), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("edit")
    public ResponseEntity<?> editCollateralType(@RequestBody CollateralType collateralType) {
        try{
            collateralTypeService.editOne(collateralType);
            return new ResponseEntity<>(
                    new ApiResponse<>("Thành công",null), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse<>(e.getMessage(), null), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteCollateralType(@RequestBody List<Integer> list) {
        List<String> listErr = collateralTypeService.deleteType(list);
        if (listErr.isEmpty()){
            return new ResponseEntity<>(
                    new ApiResponse<>(Messeger.DELETE_OK.getMessage(), null), HttpStatus.OK
            );
        }else {
            return  new ResponseEntity<>(
                    new ApiResponse<>(listErr.toString() +" " +Messeger.DELETE_FAIL.getMessage(), null), HttpStatus.CONFLICT
            );
        }
    }
}
