package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "LoanPurpose")
public class LoanPurpose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "PurposeName")
    private String purposeName;

    @Column(name = "InputedDate")
    private Date inputedDate;

    @Column(name = "InputedUser")
    private String inputedUser;
}
