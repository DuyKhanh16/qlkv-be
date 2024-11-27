package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "ProjectType")
public class ProjectType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "TypeDesc")
    private String typeDesc;

    @Column(name = "InputedDate")
    private LocalDate inputedDate;

    @Column(name = "InputedUser")
    private String inputedUser;

    @Column(name = "Name")
    private String name;

}