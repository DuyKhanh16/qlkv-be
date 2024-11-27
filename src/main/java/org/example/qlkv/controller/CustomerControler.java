package org.example.qlkv.controller;

import org.example.qlkv.DTO.ApiResponse;
import org.example.qlkv.entity.Customer;
import org.example.qlkv.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/customers")
public class CustomerControler {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllCustomers() {
        List<Customer> result = customerService.getAllKhachHang();
        return new ResponseEntity<>(
                new ApiResponse<>("Thành công",result),
                HttpStatus.OK
        );
    }
}
