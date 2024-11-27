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
    private int loanId;

    @Column(name = "ContractNo")
    private String contractNo;

    @Column(name = "BorrowerID")
    private int borrowerId;

    @Column(name = "LenderID")
    private int lenderId;

    @Column(name = "UsedCapID")
    private int usedCapId;

    @Column(name = "ContractType")
    private String contractType;

    @Column(name = "ProjectID1")
    private int projectId1;

    @Column(name = "ProjectID2")
    private int projectId2;

    @Column(name = "ProjectID3")
    private int projectId3;

    @Column(name = "ProjectID4")
    private int projectId4;

    @Column(name = "ProjectID5")
    private int projectId5;

    @Column(name = "ProjectID6")
    private int projectId6;

    @Column(name = "ProjectID7")
    private int projectId7;

    @Column(name = "ProjectID8")
    private int projectId8;

    @Column(name = "ProjectID9")
    private int projectId9;

    @Column(name = "ProjectID10")
    private int projectId10;

    @Column(name = "ProjectID11")
    private int projectId11;

    @Column(name = "ProjectID12")
    private int projectId12;

    @Column(name = "ProjectID13")
    private int projectId13;

    @Column(name = "ProjectID14")
    private int projectId14;

    @Column(name = "ProjectID15")
    private int projectId15;

    @Column(name = "LoanName")
    private String loanName;

    @Column(name = "PurposeID1")
    private int purposeId1;

    @Column(name = "PurposeID2")
    private int purposeId2;

    @Column(name = "PurposeID3")
    private int purposeId3;

    @Column(name = "PurposeID4")
    private int purposeId4;

    @Column(name = "PurposeID5")
    private int purposeId5;

    @Column(name = "PurposeID6")
    private int purposeId6;

    @Column(name = "PurposeID7")
    private int purposeId7;

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
    private int loanPeriod;

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
