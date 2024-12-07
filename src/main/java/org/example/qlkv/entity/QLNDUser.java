package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "QLNDUser")
public class QLNDUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

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

    @Column(name = "Title")
    private String title;

    @Column(name = "MangUser")
    private String mangUser;


}
