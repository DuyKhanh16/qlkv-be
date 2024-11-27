package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "QLNDGroupRoleAssignment")
public class QLNDGroupRoleAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "GroupId")
    private String groupId;

    @Column(name = "RoleAssignmentId")
    private String roleAssignmentId;
}
