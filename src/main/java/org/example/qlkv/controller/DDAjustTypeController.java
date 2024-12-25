package org.example.qlkv.controller;

import org.example.qlkv.DTO.ApiResponse;
import org.example.qlkv.entity.DDAjustType;
import org.example.qlkv.service.DDAjustTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/ddajust-type")
public class DDAjustTypeController {

    @Autowired
    private DDAjustTypeService ddaustTypeService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllDdaustTypes() {
        List<DDAjustType> list = ddaustTypeService.getAll();
        return new ResponseEntity<>(
                new ApiResponse<>("Thành công",list),
                HttpStatus.OK
        );
    }
}
