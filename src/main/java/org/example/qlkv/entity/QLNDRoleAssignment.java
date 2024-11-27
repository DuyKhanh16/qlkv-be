package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "QLNDRoleAssignment")
public class QLNDRoleAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;

    @Column(name = "ScopeLevel", nullable = false)
    private String scopeLevel;

    @Column(name = "AppCode")
    private String appCode;

    @Column(name = "ModuleCode")
    private String moduleCode;

    @Column(name = "ItemId")
    private String itemId;

    @Column(name = "RoleDefinitionId")
    private String roleDefinitionId;
}
