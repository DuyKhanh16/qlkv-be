package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "loanMng")
public class LoanMng {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "USERID")
    private String userId;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "CompanyID")
    private int companyId;

    @Column(name = "InputedDate")
    private Date inputedDate;

    @Column(name = "InputedUser")
    private String inputedUser;
}
