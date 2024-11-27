package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "QLNDRoleDefinitionRight")
public class QLNDRoleDefinitionRight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "RoleDefinitionId")
    private int roleDefinitionId;

    @Column(name = "RightCode")
    private String rightCode;
}
