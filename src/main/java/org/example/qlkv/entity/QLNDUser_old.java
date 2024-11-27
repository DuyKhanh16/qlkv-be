package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "QLNDUser_old")
public class QLNDUser_old {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;

    @Column(name = "LoginName", nullable = false)
    private String loginName;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "Department")
    private String department;

    @Column(name = "Company")
    private String company;

    @Column(name = "Status")
    private String status;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Address")
    private String address;

    @Column(name = "CreateDate")
    private String createDate;

    @Column(name = "ModifiedDate")
    private String modifiedDate;

    @Column(name = "Notes")
    private String notes;

}
