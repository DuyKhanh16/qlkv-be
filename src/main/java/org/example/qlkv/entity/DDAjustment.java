package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;


import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "DDAjustment")
public class DDAjustment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "LoanID")
    private int loanID;

    @Column(name = "DrawdownID")
    private int drawdownID;

    @Column(name = "DDAjustTypeID")
    private String dajustTypeID;

    @Column(name = "TypePayment")
    private String typePayment;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Amount")
    private BigDecimal amount;

    @Column(name = "InputedDate")
    private LocalDateTime inputedDate;

    @Column(name = "InputedUser")
    private String inputedUser;

}
