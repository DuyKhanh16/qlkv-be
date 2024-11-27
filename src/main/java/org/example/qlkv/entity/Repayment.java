package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Repayment")
@Data
public class Repayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "LoanID", nullable = false)
    private int loanId;

    @Column(name = "DrawdownID", nullable = false)
    private int drawdownId;

    @Column(name = "TypeAmt")
    private String typeAmt;

    @Column(name = "PaymentDate")
    private LocalDateTime paymentDate;

    @Column(name = "Amount")
    private BigDecimal amount;

    @Column(name = "Status")
    private String status;

    @Column(name = "InputedDate")
    private LocalDateTime inputedDate;

    @Column(name = "InputedUser")
    private String inputedUser;
}
