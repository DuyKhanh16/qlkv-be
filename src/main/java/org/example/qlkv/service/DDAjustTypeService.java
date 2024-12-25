package org.example.qlkv.service;

import org.example.qlkv.entity.DDAjustType;
import org.example.qlkv.repository.DDAjustTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DDAjustTypeService {
    @Autowired
    private DDAjustTypeRepo daustTypeRepo;

    public List<DDAjustType> getAll() {
        return daustTypeRepo.findAll();
    }
}
