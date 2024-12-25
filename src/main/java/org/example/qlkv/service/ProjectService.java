package org.example.qlkv.service;

import jakarta.persistence.Tuple;
import org.example.qlkv.DTO.request.CreateProjectDTO;
import org.example.qlkv.DTO.request.ProjectExcelDTO;
import org.example.qlkv.DTO.response.ProjectDTO;
import org.example.qlkv.DTO.response.ProjectSelectDTO;
import org.example.qlkv.entity.Customer;
import org.example.qlkv.entity.Project;
import org.example.qlkv.entity.ProjectType;
import org.example.qlkv.repository.CustomerRepo;
import org.example.qlkv.repository.ProjectRepo;
import org.example.qlkv.repository.TypeProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private TypeProjectRepo typeProjectRepo;

    public Project getOnePorject(int id) {
        Project project =projectRepo.findById(id).get();
        return project;
    }
    public List<ProjectDTO> getAllProjects() {
        List<Tuple> result = projectRepo.getallProjectRalationShip();
        if (!result.isEmpty()) {
            System.out.println(result);
            return result.stream()
                    .map(row -> new ProjectDTO(
                            row.get("id", Integer.class),
                            row.get("projectNo", String.class),
                            row.get("projectName", String.class),
                            row.get("name", String.class),
                            row.get("nameType", String.class),
                            row.get("startDate", LocalDate.class),
                            row.get("endDate", LocalDate.class),
                            row.get("budget", BigDecimal.class),
                            row.get("ccy", String.class),
                            row.get("legalRecord", String.class),
                            row.get("recentValue", BigDecimal.class),
                            row.get("quantity", BigDecimal.class),
                            row.get("projectLocation", String.class),
                            row.get("unit", String.class),
                            row.get("description", String.class),
                            row.get("status", String.class)
                    ))
                    .collect(Collectors.toList()); // Collect the results into a List
        }

        return Collections.emptyList(); // Return empty list if result is empty
    }


    private LocalDate convertDate(String date) {
        if (date == null || date =="") {
            return null;
        }
        // Định dạng cho dữ liệu đầu vào "MM/DD/YYYY"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        try {
            // Chuyển đổi chuỗi thành LocalDate
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Invalid date format. Please use MM/DD/YYYY.");
        }
    }

    private Project convertProject(CreateProjectDTO project) {
        Project newProject = new Project();
        newProject.setId(project.getId());
        newProject.setProjectNo(project.getProjectNo());
        newProject.setProjectName(project.getProjectName());
        newProject.setStartDate(convertDate(project.getStartDate()));
        newProject.setEndDate(convertDate(project.getEndDate()));
        newProject.setBudget(project.getBudget());
        newProject.setDescription(project.getDescription());
        newProject.setStatus(project.getStatus());
        newProject.setProjectOwner(project.getProjectOwner());
        newProject.setDisbursers(project.getDisbursers());
        newProject.setMangUser(project.getMangUser());
        newProject.setInputedDate(LocalDateTime.now());
        newProject.setInputedUser(project.getInputedUser());
        newProject.setProjectLocation(project.getProjectLocation());
        newProject.setUnit(project.getUnit());
        newProject.setRecentValue(project.getRecentValue());
        newProject.setCcy(project.getCcy());
        newProject.setLegalRecord(project.getLegalRecord());
        newProject.setQuantity(project.getQuantity());
        newProject.setProjectTypeId(project.getProjectTypeId());
        newProject.setProjectOwnerId(project.getProjectOwnerId());

        return newProject;
    }

    public Optional<?> createOneProject (CreateProjectDTO project){
       Project result =projectRepo.findByProjectNo(project.getProjectNo());
      if (result != null){
          throw new RuntimeException("Mã Dự án đã tồn tại");
      }
      Project checkName = projectRepo.findByProjectName(project.getProjectName());
      if (checkName != null){
          throw new RuntimeException("Tên dự án đã tồn tại");
      }
        Project newProject = convertProject(project);


      return Optional.of(projectRepo.save(newProject));
    }

    public Optional updateOneProject (CreateProjectDTO project){
        Project result =projectRepo.findByProjectNo(project.getProjectNo());
        if (result != null&&result.getId()!=project.getId()){
            throw new RuntimeException("Mã Dự án bị trùng với dự án khác");
        }
        Project checkName = projectRepo.findByProjectName(project.getProjectName());
        if (checkName != null && checkName.getId()!=project.getId()){
            throw new RuntimeException("Tên dự án bị trùng với dự án khác");
        }
        Project newProject = convertProject(project);
        return Optional.of(projectRepo.save(newProject));
    }

    public List<String> deteleProject (List<Integer> listdelete){
        List<String> projectList = new ArrayList<>();
        for (Integer id : listdelete) {
            Project project=projectRepo.findRelationshipLoan(id);
            if (project != null) {
                projectList.add(project.getProjectName());
            }else {
                projectRepo.deleteById(id);
            }

        }
        return projectList;
    }

    public List<Project> saveExcelProject(List<ProjectExcelDTO> dataExcel, String mangUser, String inputedUser){
        List<Project> projects = dataExcel.stream()
                .map(this::convertToEntity)
                .filter(this::isValidProject)
                .map(project -> processProject(project, mangUser, inputedUser))
                .collect(Collectors.toList());

        return projectRepo.saveAll(projects);
    };

    private Project convertToEntity(ProjectExcelDTO projectExcelDTO){
        Project project = new Project();
        project.setProjectNo(projectExcelDTO.getProjectNo());
        project.setProjectName(projectExcelDTO.getProjectName());
        project.setStartDate(convertDate(projectExcelDTO.getStartDate()));
        project.setEndDate(convertDate(projectExcelDTO.getEndDate()));
        project.setProjectLocation(projectExcelDTO.getProjectLocation());
        project.setUnit(projectExcelDTO.getUnit());
        project.setQuantity(projectExcelDTO.getQuantity());
        project.setCcy(projectExcelDTO.getCcy());
        project.setBudget(projectExcelDTO.getBudget());
        project.setRecentValue(projectExcelDTO.getRecentValue());
        project.setLegalRecord(projectExcelDTO.getLegalRecord());
        project.setDescription(projectExcelDTO.getDescription());
        project.setStatus(projectExcelDTO.getStatus());
        project.setProjectOwnerId(convertCustomeName(projectExcelDTO.getName()));
        project.setProjectTypeId(convertTypeProject(projectExcelDTO.getProjectType()));
        return project;
    }

    private Project processProject (Project project,String mangUser, String inputedUser){
        project.setMangUser(mangUser);
        project.setInputedDate(LocalDateTime.now());
        project.setInputedUser(inputedUser);
        return project;
    };
    private Integer convertCustomeName(String name){
        Customer customer =customerRepo.findByName(name);
        if (customer != null){
            return customer.getId();
        }
        throw new RuntimeException(name +"chưa tồn tại tronmg hệ thống");
    }
    private Integer convertTypeProject(String name){
        ProjectType projectType= typeProjectRepo.findByName(name);
        if(projectType != null){
            return projectType.getId();
        }
        throw new RuntimeException(name +"chưa tồn tại tronmg hệ thống");
    }
    private boolean isValidProject(Project project) {
        Project checkNo=projectRepo.findByProjectNo(project.getProjectNo());
        if (checkNo != null){
            throw new RuntimeException(project.getProjectNo()+"đã tồn tại trong hệ thống");
        }
        Optional<Project> existingCustomer = projectRepo.findByProjectNameAndProjectNo(
          project.getProjectName(),project.getProjectNo()
        );
        if (existingCustomer.isPresent()) {
            throw new RuntimeException(  project.getProjectName() +" "+ "Hoặc" +" " +project.getProjectNo()+ "đã tồn tại trong hệ thống");
        }
        return existingCustomer.isEmpty(); // Chỉ lưu nếu không trùng
    }


    public List<ProjectSelectDTO> getSelect(int userCapId){
        List<Tuple> result;
        if (userCapId ==0) {
             result = projectRepo.getIdAndProjectName();
        }else {
            result = projectRepo.getIdAndProjectNameByID(userCapId);
        }
        if (!result.isEmpty()){
            return  result.stream().map(r->new ProjectSelectDTO(
                    r.get("id",Integer.class),
                    r.get("projectName", String.class),
                    r.get("projectNo", String.class)
            )).collect(Collectors.toList());
        }
        return null;
    }
}
