package org.example.qlkv.service;

import org.example.qlkv.DTO.request.ProjectTypeDto;
import org.example.qlkv.entity.ProjectType;
import org.example.qlkv.repository.ProjectRepo;
import org.example.qlkv.repository.TypeProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectTypeService {
    @Autowired
    private TypeProjectRepo typeProjectRepo;



    public List<ProjectType> getAllProjectTypes() {
        return typeProjectRepo.findAll();
    }

    public ProjectType createNewType(ProjectTypeDto projectTypeDto) {
        ProjectType projectType = typeProjectRepo.findByName(projectTypeDto.getName());
        if (projectType != null) {
            throw new RuntimeException("Loại dự án đã tôn tại");
        }

                ProjectType newProjectType = new ProjectType();
        newProjectType.setName(projectTypeDto.getName());
        newProjectType.setTypeDesc(projectTypeDto.getTypeDesc());
        newProjectType.setInputedUser(projectTypeDto.getInputedUser());
        newProjectType.setInputedDate(LocalDateTime.now());
        return typeProjectRepo.save(newProjectType);
    }

    public List<String> deleteProjectType(List<Integer> Listid) {
        List<String> listErr = new ArrayList<String>();
        for(Integer i : Listid) {
            Optional<ProjectType> projectType = typeProjectRepo.findByProjectTypeRelationProject(i);
            if (projectType.isPresent()) {
                listErr.add(projectType.get().getName());
            }else {
                typeProjectRepo.deleteById(i);
            }
        }
        return  listErr;
    }

    public ProjectType updateOne(ProjectType projectType){
        return typeProjectRepo.save(projectType);
    }
}
