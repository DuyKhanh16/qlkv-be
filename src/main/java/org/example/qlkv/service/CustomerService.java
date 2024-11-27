package org.example.qlkv.service;

import org.example.qlkv.entity.Customer;
import org.example.qlkv.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllKhachHang(){
        List<Customer> listKH= customerRepository.findAll();
        return listKH;
    }
}
