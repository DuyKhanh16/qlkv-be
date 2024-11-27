package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class QLNDUserRoleAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "UserId")
    private String userId;

    @Column(name = "RoleAssignmentId")
    private String roleAssignmentId;
}
