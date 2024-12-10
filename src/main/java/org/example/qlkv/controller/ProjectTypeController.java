package org.example.qlkv.controller;

import org.example.qlkv.DTO.ApiResponse;
import org.example.qlkv.DTO.request.ProjectTypeDto;
import org.example.qlkv.entity.ProjectType;
import org.example.qlkv.service.ProjectTypeService;
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
@RequestMapping("api/type-project")
public class ProjectTypeController {
    @Autowired
    private ProjectTypeService projectTypeService;

    @GetMapping("/list")
    public ResponseEntity<?> getListProjectType() {
        try{
            List<ProjectType> list = projectTypeService.getAllProjectTypes();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(

                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProjectType(@RequestBody ProjectTypeDto projectType) {
        try{
            projectTypeService.createNewType(projectType);
            return new ResponseEntity<>("Tạo mới thành công",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.CONFLICT
            );
        }
    }
}
