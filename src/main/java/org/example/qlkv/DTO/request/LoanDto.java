package org.example.qlkv.DTO.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanDto {
    private String contractNo;
    private int borrowerId;
    private int lenderId;
    private int usedCapId;
    private String contractType;
    private int projectId1;
    private String loanName;
    private Integer purposeId1;
    private Integer purposeId2;
    private Integer purposeId3;
    private Integer purposeId4;
    private Integer purposeId5;
    private Integer purposeId6;
    private Integer purposeId7;
    private BigDecimal loanAmountPurpose1;
    private BigDecimal loanAmountPurpose2;
    private BigDecimal loanAmountPurpose3;
    private BigDecimal loanAmountPurpose4;
    private BigDecimal loanAmountPurpose5;
    private BigDecimal loanAmountPurpose6;
    private BigDecimal loanAmountPurpose7;
    private String fromDate;
    private String endDate;
    private BigDecimal loanAmount;
    private String ccy;
    private String loanStatus;
    private String comment;
    private String mangUser;
    private String inputedUser;
    private String loanPeriod;
    private BigDecimal equityCapital;
    private BigDecimal interestRate1;
    private String descriptionInterestRate;
    private BigDecimal fee1;
    private BigDecimal fee2;
    private BigDecimal fee3;
    private String description;

}
