package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "DrawdownIntRate")
public class DrawdownIntRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "LoanID", nullable = false)
    private Integer loanId;

    @Column(name = "DrawdownID", nullable = false)
    private Long drawdownId;

    @Column(name = "InterestRate")
    private Float interestRate;

    @Column(name = "PriPenatyRate")
    private Float priPenatyRate;

    @Column(name = "IntPenatyRate")
    private Float intPenatyRate;

    @Column(name = "EffectiveDate", nullable = false)
    private LocalDateTime effectiveDate;

    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "InputedDate", nullable = false)
    private LocalDateTime inputedDate;

    @Column(name = "InputedUser", length = 50)
    private String inputedUser;
}
