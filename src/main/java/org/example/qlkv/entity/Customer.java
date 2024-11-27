package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table (name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column (name = "Name" ,columnDefinition = "nvarchar(500)")
    private String name;

    @Column (name = "Abbreviation" ,columnDefinition = "nvarchar(255)")
    private String Abbreviation;

    @Column (name = "Address" ,columnDefinition = "nvarchar(max)")
    private String address;

    @Column (name = "BusRegist" ,columnDefinition = "nchar(40)")
    private String BusRegist;

    @Column (name = "MangUser")
    private String MangUser;

    @Column (name ="InputedDate")
    private Date InputedDate;

    @Column (name ="InputedUser")
    private String InputedUser;

    @Column (name = "CharterCapital")
    private BigDecimal CharterCapital;

    @Column (name = "RecentRevenue")
    private BigDecimal RecentRevenue;

    @Column (name = "RecentProfit")
    private BigDecimal RecentProfit;

    @Column (name = "CusAccountNumber")
    private String CusAccountNumber;

    @Column(name = "CustomerType")
    private Integer CustomerType;

    @Column (name = "Gender")
    private Integer Gender;

    @Column (name = "DateOfBirth")
    private Date DateOfBirth;

    @Column (name = "DateOfIssue")
    private Date DateOfIssue;

    @Column(name = "Phone")
    private String Phone;

    @Column(name = "Email")
    private String Email;

    @Column(name = "BankName")
    private String BankName;
}
