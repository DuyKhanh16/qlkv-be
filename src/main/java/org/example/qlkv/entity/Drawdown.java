package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Drawdown")
@Data
public class Drawdown {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DrawdownID")
    private Long drawdownId;

    @Column(name = "LoanID", nullable = false)
    private Integer loanId;

    @Column(name = "DDPeriod")
    private String ddPeriod;

    @Column(name = "FromDate")
    private LocalDateTime fromDate;

    @Column(name = "EndDate")
    private LocalDateTime endDate;

    @Column(name = "DDAmount", precision = 18, scale = 2)
    private BigDecimal ddAmount;

    @Column(name = "CCY", length = 50)
    private String currency;

    @Column(name = "IntRate")
    private Float intRate;

    @Column(name = "PriPenatyRate")
    private Float priPenatyRate;

    @Column(name = "IntPenatyRate")
    private Float intPenatyRate;

    @Column(name = "NextPriPaymentAmt")
    private Float nextPriPaymentAmt;

    @Column(name = "NextPriPaymentDate")
    private LocalDateTime nextPriPaymentDate;

    @Column(name = "NextIntPaymentAmt", precision = 18, scale = 2)
    private BigDecimal nextIntPaymentAmt;

    @Column(name = "NextIntPaymentDate")
    private LocalDateTime nextIntPaymentDate;

    @Column(name = "OutPriAmt", precision = 18, scale = 2)
    private BigDecimal outPriAmt;

    @Column(name = "OverduePriAmt", precision = 18, scale = 2)
    private BigDecimal overduePriAmt;

    @Column(name = "OverdueIntAmt", precision = 18, scale = 2)
    private BigDecimal overdueIntAmt;

    @Column(name = "OutIntODFromPriAmt", precision = 18, scale = 2)
    private BigDecimal outIntODFromPriAmt;

    @Column(name = "OutIntODFromtIntAmt", precision = 18, scale = 2)
    private BigDecimal outIntODFromtIntAmt;

    @Column(name = "LastPaymentIntDate")
    private LocalDateTime lastPaymentIntDate;

    @Column(name = "LastPaymentPriDate")
    private LocalDateTime lastPaymentPriDate;

    @Column(name = "DayBasis")
    private String dayBasis;

    @Column(name = "DDStatus")
    private String ddStatus;

    @Column(name = "MangUser")
    private String mangUser;

    @Column(name = "InputedDate")
    private LocalDateTime inputedDate;

    @Column(name = "InputedUser")
    private String inputedUser;

    @Column(name = "DrawdownNo")
    private String drawdownNo;

    @Column(name = "PurposeID1")
    private Integer purposeId1;

    @Column(name = "PurposeID2")
    private Integer purposeId2;

    @Column(name = "PurposeID3")
    private Integer purposeId3;

    @Column(name = "PurposeID4")
    private Integer purposeId4;

    @Column(name = "PurposeID5")
    private Integer purposeId5;

    @Column(name = "PurposeID6")
    private Integer purposeId6;

    @Column(name = "PurposeID7")
    private Integer purposeId7;

    @Column(name = "DDAmountPurpose1", precision = 18, scale = 2)
    private BigDecimal ddAmountPurpose1;

    @Column(name = "DDAmountPurpose2", precision = 18, scale = 2)
    private BigDecimal ddAmountPurpose2;

    @Column(name = "DDAmountPurpose3", precision = 18, scale = 2)
    private BigDecimal ddAmountPurpose3;

    @Column(name = "DDAmountPurpose4", precision = 18, scale = 2)
    private BigDecimal ddAmountPurpose4;

    @Column(name = "DDAmountPurpose5", precision = 18, scale = 2)
    private BigDecimal ddAmountPurpose5;

    @Column(name = "DDAmountPurpose6", precision = 18, scale = 2)
    private BigDecimal ddAmountPurpose6;

    @Column(name = "DDAmountPurpose7", precision = 18, scale = 2)
    private BigDecimal ddAmountPurpose7;

}
