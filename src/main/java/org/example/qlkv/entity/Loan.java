package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LoanID")
    private Integer loanId;

    @Column(name = "ContractNo")
    private String contractNo;

    @Column(name = "BorrowerID")
    private Integer borrowerId;

    @Column(name = "LenderID")
    private Integer lenderId;

    @Column(name = "UsedCapID")
    private Integer usedCapId;

    @Column(name = "ContractType")
    private String contractType;

    @Column(name = "ProjectID1")
    private Integer projectId1;

    @Column(name = "ProjectID2")
    private Integer projectId2;

    @Column(name = "ProjectID3")
    private Integer projectId3;

    @Column(name = "ProjectID4")
    private Integer projectId4;

    @Column(name = "ProjectID5")
    private Integer projectId5;

    @Column(name = "ProjectID6")
    private Integer projectId6;

    @Column(name = "ProjectID7")
    private Integer projectId7;

    @Column(name = "ProjectID8")
    private Integer projectId8;

    @Column(name = "ProjectID9")
    private Integer projectId9;

    @Column(name = "ProjectID10")
    private Integer projectId10;

    @Column(name = "ProjectID11")
    private Integer projectId11;

    @Column(name = "ProjectID12")
    private Integer projectId12;

    @Column(name = "ProjectID13")
    private Integer projectId13;

    @Column(name = "ProjectID14")
    private Integer projectId14;

    @Column(name = "ProjectID15")
    private Integer projectId15;

    @Column(name = "LoanName")
    private String loanName;

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

    @Column(name = "LoanAmountPurpose1")
    private BigDecimal loanAmountPurpose1;

    @Column(name = "LoanAmountPurpose2")
    private BigDecimal loanAmountPurpose2;

    @Column(name = "LoanAmountPurpose3")
    private BigDecimal loanAmountPurpose3;

    @Column(name = "LoanAmountPurpose4")
    private BigDecimal loanAmountPurpose4;

    @Column(name = "LoanAmountPurpose5")
    private BigDecimal loanAmountPurpose5;

    @Column(name = "LoanAmountPurpose6")
    private BigDecimal loanAmountPurpose6;

    @Column(name = "LoanAmountPurpose7")
    private BigDecimal loanAmountPurpose7;

    @Column(name = "FromDate")
    private LocalDateTime fromDate;

    @Column(name = "EndDate")
    private LocalDateTime endDate;

    @Column(name = "LoanAmount")
    private BigDecimal loanAmount;

    @Column(name = "CCY")
    private String ccy;

    @Column(name = "KindPriPenatyRate")
    private Float kindPriPenatyRate;

    @Column(name = "KindIntPenatyRate")
    private Float kindIntPenatyRate;

    @Column(name = "DayBasis")
    private String dayBasis;

    @Column(name = "LoanStatus")
    private String loanStatus;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "MangUser")
    private String mangUser;

    @Column(name = "InputedDate")
    private LocalDateTime inputedDate;

    @Column(name = "InputedUser")
    private String inputedUser;

    @Column(name = "LoanPeriod")
    private String loanPeriod;

    @Column(name = "EquityCapital")
    private BigDecimal equityCapital;

    @Column(name = "BankName")
    private String bankName;

    @Column(name = "InterestRate1")
    private BigDecimal interestRate1;

    @Column(name = "DescriptionInterestRate")
    private String descriptionInterestRate;

    @Column(name = "Fee1")
    private BigDecimal fee1;

    @Column(name = "Fee2")
    private BigDecimal fee2;

    @Column(name = "Fee3")
    private BigDecimal fee3;

    @Column(name = "Description")
    private String description;

}
