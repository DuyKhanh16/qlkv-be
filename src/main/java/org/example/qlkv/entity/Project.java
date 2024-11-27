package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table (name = "Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "ProjectTypeID")
    private int projectTypeId;

    @Column(name = "ProjectOwnerID")
    private int projectOwnerId;

    @Column(name = "ProjectName")
    private String projectName;

    @Column(name = "StartDate")
    private LocalDateTime startDate;

    @Column(name = "EndDate")
    private LocalDateTime endDate;

    @Column(name = "Budget")
    private BigDecimal budget;

    @Column(name = "Description")
    private String description;

    @Column(name = "Status")
    private String status;

    @Column(name = "ProjectOwner")
    private String projectOwner;

    @Column(name = "Disbursers")
    private String disbursers;

    @Column(name = "MangUser")
    private String mangUser;

    @Column(name = "InputedDate")
    private LocalDateTime inputedDate;

    @Column(name = "InputedUser")
    private String inputedUser;

    @Column(name = "ProjectLocation")
    private String projectLocation;

    @Column(name = "LegalRecord")
    private String legalRecord;

    @Column(name = "RecentValue")
    private BigDecimal recentValue;

    @Column(name = "ProjectNo")
    private String projectNo;

    @Column(name = "CCY")
    private String ccy;

    @Column(name = "Quantity")
    private BigDecimal quantity;

    @Column(name = "Unit")
    private String unit;;
}
