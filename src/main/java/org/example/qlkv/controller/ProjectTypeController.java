package org.example.qlkv.controller;

import org.example.qlkv.DTO.ApiResponse;
import org.example.qlkv.DTO.request.ProjectTypeDto;
import org.example.qlkv.entity.ProjectType;
import org.example.qlkv.exception.Messeger;
import org.example.qlkv.service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/delete")
    public ResponseEntity<?> deleteProjectType(@RequestBody List<Integer> listDelete) {
        List<String> listErr=projectTypeService.deleteProjectType(listDelete);
        if (listErr.isEmpty()) {
            return new ResponseEntity<>(
                    Messeger.DELETE_OK,
                    HttpStatus.OK);

        }
        return new ResponseEntity<>(
                new ApiResponse<>(listErr.toString() +"Không thể xóa",null),
                HttpStatus.CONFLICT
        );
    }

    @PatchMapping("update-one")
    public ResponseEntity<?> updateProjectType(@RequestBody ProjectType projectType) {
        try{
            projectTypeService.updateOne(projectType);
              return new ResponseEntity<>(
                    new ApiResponse<>("Thành công",null)
                    ,HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ApiResponse<>(e.getMessage(),null)
                    ,HttpStatus.CONFLICT
            );
        }
    }


}
