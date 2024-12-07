package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "IntCaculateEnquiry")
public class IntCaculateEnquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "LoanID", nullable = false)
    private int loanId;

    @Column(name = "DDID", nullable = false)
    private int ddId;

    @Column(name = "PriOut")
    private BigDecimal priOut;

    @Column(name = "PriAmtDue")
    private BigDecimal priAmtDue;

    @Column(name = "IntAmtDue")
    private BigDecimal intAmtDue;

    @Column(name = "PriOdOut")
    private BigDecimal priOdOut;

    @Column(name = "IntOdOut")
    private BigDecimal intOdOut;

    @Column(name = "PriOdiAmtDue")
    private BigDecimal priOdiAmtDue;

    @Column(name = "IntOdiAmtDue")
    private BigDecimal intOdiAmtDue;

    @Column(name = "FromDate")
    private LocalDateTime fromDate;

    @Column(name = "ToDate")
    private LocalDateTime toDate;

    @Column(name = "IntRate")
    private Float intRate;

    @Column(name = "OdiIntRate")
    private Float odiIntRate;

    @Column(name = "OdiPriRate")
    private Float odiPriRate;

    @Column(name = "RunDate")
    private LocalDateTime runDate;

    @Column(name = "InputedUser")
    private String inputedUser;

    @Column(name = "InputedDate")
    private LocalDateTime inputedDate;

}
