package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "PaymentSchedule")
public class PaymentSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "LoanID")
    private int loanId;

    @Column(name = "DrawdownID")
    private int drawdownId;

    @Column(name = "TypePayment")
    private String typePayment;

    @Column(name = "DueDate")
    private LocalDateTime dueDate;

    @Column(name = "Amount")
    private BigDecimal amount;

    @Column(name = "Status")
    private String status;

    @Column(name = "InputedDate")
    private LocalDateTime inputedDate;

    @Column(name = "InputedUser")
    private String inputedUser;

}
