package org.example.qlkv.controller;

import org.example.qlkv.DTO.ApiResponse;
import org.example.qlkv.DTO.request.CreateProjectDTO;
import org.example.qlkv.DTO.request.ProjectExcelDTO;
import org.example.qlkv.DTO.response.ProjectDTO;
import org.example.qlkv.DTO.response.ProjectSelectDTO;
import org.example.qlkv.entity.Customer;
import org.example.qlkv.entity.Project;
import org.example.qlkv.exception.Messeger;
import org.example.qlkv.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/get-one")
    public ResponseEntity<?> getOne(@RequestParam int id) {
        System.out.println(id);
        Project project= projectService.getOnePorject(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity getAllProjects() {
       List<ProjectDTO> projects = projectService.getAllProjects();
        return new ResponseEntity(
                new ApiResponse<>("Thành công",projects),
                HttpStatus.OK
        );
    }

    @PostMapping("create-one")
public ResponseEntity<?> createOneProject(@RequestBody CreateProjectDTO project) {
        try{
            projectService.createOneProject(project);
            return new ResponseEntity<>(
                    new ApiResponse<>("Tạo thành công dự án",null),
                    HttpStatus.CREATED
            );
        }catch (Exception e) {
            return new ResponseEntity<>(
                    new ApiResponse<>(e.getMessage(),null),
                    HttpStatus.CONFLICT
            );
        }
    }

    @PatchMapping("/update-one")
    public ResponseEntity<?> updateOneProject(@RequestBody CreateProjectDTO project) {
        try{
            projectService.updateOneProject(project);
            return new ResponseEntity<>(
                    new ApiResponse<>("Chỉnh sửa thành công" ,null),
                    HttpStatus.OK
            );
        }catch (Exception e) {
            return new ResponseEntity<>(
                    new ApiResponse<>(e.getMessage() ,null),
                    HttpStatus.CONFLICT
            );
        }

    }

    @PostMapping("/delete")
    public ResponseEntity<?> dteleteProject(@RequestBody List<Integer> listDelete) {
        List<String> listErro = projectService.deteleProject(listDelete);
        if (listErro.isEmpty()) {
            return new ResponseEntity<>(
                    new ApiResponse<>("Xóa thành công",null),
                    HttpStatus.OK
            );
        }else {
            return new ResponseEntity<>(
                    new ApiResponse<>("Không thể xóa" + listErro.toString() ,null),
                    HttpStatus.CONFLICT
            );}
    }

    @PostMapping("/excel-import")
    public ResponseEntity<?> excelImporter(@RequestBody List<ProjectExcelDTO> dataExcel, @RequestParam String mangUser, @RequestParam String inputedUser) {
        try {
            List<Project> saveProject = projectService.saveExcelProject(dataExcel, mangUser, inputedUser);
            return new ResponseEntity<>(
                    new ApiResponse<>("Nhập thành công",null),
                    HttpStatus.CREATED
            );
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list-select")
    public ResponseEntity<?> listSelect(@RequestParam Integer userCapId ) {
        List<ProjectSelectDTO> list =projectService.getSelect(userCapId);
        return new ResponseEntity<>(new ApiResponse<>(Messeger.SUCCESS.getMessage(), list),HttpStatus.OK);
    }
}
