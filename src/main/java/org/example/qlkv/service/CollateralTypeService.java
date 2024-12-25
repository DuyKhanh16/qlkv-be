package org.example.qlkv.service;

import org.example.qlkv.entity.CollateralType;
import org.example.qlkv.repository.CollateralTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CollateralTypeService {
    @Autowired
    private CollateralTypeRepo collateralTypeRepo;

    public List<CollateralType> getAllCollateralTypes() {
        return collateralTypeRepo.findAll();
    };

    public CollateralType createNew(CollateralType collateralType) {
        CollateralType newCollateralType = collateralTypeRepo.findByCollateralTypeNo(collateralType.getCollateralTypeNo());

        if (newCollateralType != null) {
            throw  new RuntimeException(collateralType.getCollateralTypeNo() + " Đã tồn tại");
        }
        CollateralType newCollateralType1 = new CollateralType();
        newCollateralType1.setCollateralTypeNo(collateralType.getCollateralTypeNo());
        newCollateralType1.setDescription(collateralType.getDescription());
        newCollateralType1.setInputedUser(collateralType.getInputedUser());
        newCollateralType1.setInputedDate(LocalDateTime.now());
        return collateralTypeRepo.save(newCollateralType1);
    }

    public CollateralType editOne(CollateralType collateralType) {
        CollateralType checkNo=collateralTypeRepo.findByCollateralTypeNo(collateralType.getCollateralTypeNo());
        CollateralType checkDesAndNo=collateralTypeRepo.findByCollateralTypeNoOrDescription(collateralType.getCollateralTypeNo(),collateralType.getDescription());
        if (checkNo != null&& checkNo.getId() != collateralType.getId()) {
            throw new RuntimeException("Mã tài sản đảm bảo đã ồn tại");
        }
        if (checkDesAndNo != null&&checkDesAndNo.getId() !=collateralType.getId()) {
            throw new RuntimeException("loại tsdb hoặc mã tsdb đã tồn tại");
        }
       return collateralTypeRepo.save(collateralType);
    }

    public List<String> deleteType (List<Integer> list){
        List<String> listErr =new ArrayList<String>();
        for (Integer i : list) {
            Optional<CollateralType> checkCollateDelete= collateralTypeRepo.findTypeRelationCollate(i);
            if (checkCollateDelete.isPresent()) {
                listErr.add(checkCollateDelete.get().getCollateralTypeNo());
            }
            collateralTypeRepo.deleteById(i);
        }
        return listErr;
    }
}
