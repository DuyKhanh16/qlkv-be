package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Feepayment")
public class Feepayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "LoanID")
    private Integer loanId;

    @Column(name = "DrawdownID")
    private Integer drawdownId;

    @Column(name = "CollID")
    private Integer collId;

    @Column(name = "FeeTypeID")
    private Integer feeTypeId;

    @Column(name = "Description")
    private String description;

    @Column(name = "PaymentDate")
    private Date paymentDate;

    @Column(name = "CCY", length = 3)
    private String currency;

    @Column(name = "Amount")
    private Integer amount;

    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "InputedDate")
    private Date inputedDate;

    @Column(name = "InputedUser", length = 50)
    private String inputedUser;

}
