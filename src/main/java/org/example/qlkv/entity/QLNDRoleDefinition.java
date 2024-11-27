package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "QLNDRoleDefinition")
public class QLNDRoleDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Rights")
    private String rights;

    @Column(name = "Status")
    private String status;

    @Column(name = "Description")
    private String description;
}
