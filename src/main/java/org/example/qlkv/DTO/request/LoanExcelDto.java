package org.example.qlkv.DTO.request;

import lombok.Data;

import java.math.BigDecimal;

@Data

public class LoanExcelDto {

private String borrowerID;
    private String contractNo;
    private String contractType;
    private String description;
    private String descriptionInterestRate;
    private String endDate;
    private BigDecimal equityCapital;
    private BigDecimal fee1;
    private BigDecimal fee2;
    private BigDecimal fee3;
    private String fromDate;
    private BigDecimal interestRate1;
    private String lenderID;
    private BigDecimal loanAmount;
    private BigDecimal loanAmountPurpose1;
    private BigDecimal loanAmountPurpose2;
    private BigDecimal loanAmountPurpose3;
    private BigDecimal loanAmountPurpose4;
    private BigDecimal loanAmountPurpose5;
    private BigDecimal loanAmountPurpose6;
    private BigDecimal loanAmountPurpose7;
    private String loanName;
    private String loanStatus;
    private String mangUser;
    private String projectID1;
    private String purposeID1;
    private String purposeID2;
    private String purposeID3;
    private String purposeID4;
    private String purposeID5;
    private String purposeID6;
    private String purposeID7;
    private String usedCapID;
}
