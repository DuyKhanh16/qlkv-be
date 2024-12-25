package org.example.qlkv.repository;

import jakarta.persistence.Tuple;
import org.example.qlkv.DTO.UserLoginResponsi;
import org.example.qlkv.entity.QLNDUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface QLNDuserRepository extends JpaRepository<QLNDUser, UUID> {

    QLNDUser findByLoginName(String loginName);

    @Query(value = "SELECT u.LoginName AS loginName, u.FullName AS fullName, u.Password AS password, g.Name AS Name FROM QLKV_UAT.dbo.QLNDUser u JOIN QLKV_UAT.dbo.QLNDUserGroup ug ON u.Id = ug.UserId JOIN QLKV_UAT.dbo.QLNDGroup g ON ug.GroupId = g.Id WHERE u.LoginName = :loginName", nativeQuery = true)
    List<Tuple> getUserLogin(@Param("loginName") String loginName);

    @Query("select u.loginName as loginName , u.fullName as fullName from QLNDUser u")
    List<Tuple> getLoginNameAndFullName();
}
