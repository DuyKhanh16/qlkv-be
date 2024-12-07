package org.example.qlkv.controller;

import org.example.qlkv.DTO.ApiResponse;
import org.example.qlkv.DTO.request.CreateCustomDto;
import org.example.qlkv.DTO.request.CustomerExcelDTO;
import org.example.qlkv.entity.Customer;
import org.example.qlkv.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/customers", method = RequestMethod.OPTIONS)
public class CustomerControler {
    @Autowired
    private CustomerService customerService;



    @GetMapping("/list")
    public ResponseEntity<?> getAllCustomers() {
        List<Customer> result = customerService.getAllKhachHang();
        return new ResponseEntity<>(
                new ApiResponse<>("Thành công", result),
                HttpStatus.OK
        );
    }

    @PostMapping("/create-one")
    public ResponseEntity<?> createOneCustomer(@RequestBody CreateCustomDto customer) {
       if ( customerService.checkAbbreviation(customer.getAbbreviation()) != null) {
            return new ResponseEntity<>(
                    new ApiResponse<>("Tên vết tắt đã tồn tại",null),
                    HttpStatus.CONFLICT
            );
        }
       if (customerService.checkName(customer.getName()) != null){
           return new ResponseEntity<>(
                   new ApiResponse<>("Tên khách hàng đã tồn tại",null),
                   HttpStatus.CONFLICT
           );
       }
       customerService.createCustomer(customer);
        return new ResponseEntity<>(
                new ApiResponse<>("Thành công",null),
                HttpStatus.OK
        );
    }

    @PostMapping("/excel-import")
    public ResponseEntity<?> importCustomer(@RequestBody List<CustomerExcelDTO> customers, @RequestParam String mangUser, @RequestParam String inputedUser) {
        try {
            List<Customer> savedCustomers = customerService.saveCustomers(customers, mangUser, inputedUser);
            return new ResponseEntity<>(
                    new ApiResponse<>("Nhập thành công",null),
                    HttpStatus.CREATED
            );
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
