package org.example.qlkv.repository;

import jakarta.persistence.Tuple;
import org.example.qlkv.DTO.response.ProjectDTO;
import org.example.qlkv.entity.Customer;
import org.example.qlkv.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProjectRepo extends JpaRepository<Project, Integer> {

    @Query("Select p.id as id , p.projectName as projectName ,p.projectNo as projectNo,p.startDate as startDate,p.endDate as endDate,p.budget budget,p.ccy as ccy,p.legalRecord as legalRecord,p.recentValue as recentValue,p.quantity as quantity,p.projectLocation as projectLocation,p.unit as unit,p.description as description,p.status as status,c.name as name,t.name as nameType from Project p  join Customer c on p.projectOwnerId=c.id  join ProjectType t on p.projectTypeId=t.id order by p.inputedDate DESC ")
    List<Tuple> getallProjectRalationShip();

    Project findByProjectNo(String projectNo);

    Project findByProjectName(String projectName);

    @Query("SELECT p FROM Project p INNER JOIN Loan l On p.id = l.projectId1 WHERE p.id = :id")
    Project findRelationshipLoan(@Param("id") int id);

    Optional<Project> findByProjectNameAndProjectNo(String projectName, String projectNo);

    @Query("select p.id as id, p.projectName as projectName ,p.projectNo as projectNo from Project p")
    List<Tuple> getIdAndProjectName();

    @Query("select p.id as id, p.projectName as projectName ,p.projectNo as projectNo from Project p where p.projectOwnerId = :userCapId")
    List<Tuple> getIdAndProjectNameByID(@Param("userCapId") int userCapId);
}
