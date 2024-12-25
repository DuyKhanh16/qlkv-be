package org.example.qlkv.DTO.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LoanResponse {
   private Integer loanId;
   private String contractNo;
   private String borrOwer;
   private  String lender;
   private String usedCap;
   private String contractType;
   private String projectName;
   private String loanName;
   private BigDecimal loanAmount;
   private String ccy;
   private BigDecimal interestRate1;
   private String descriptionInterestRate;
   private BigDecimal fee1;
   private BigDecimal fee2;
   private BigDecimal fee3;
   private String loanPeriod;
   private LocalDateTime fromDate;
   private LocalDateTime endDate;
   private BigDecimal equityCapital;
   private String comment;
   private String mangUser;
   private String loanStatus;

   public LoanResponse(Integer loanId, String contractNo, String borrOwer, String lender, String usedCap, String contractType, String projectName, String loanName, BigDecimal loanAmount, String ccy, BigDecimal interestRate1, String descriptionInterestRate, BigDecimal fee1, BigDecimal fee2, BigDecimal fee3, String loanPeriod, LocalDateTime fromDate, LocalDateTime endDate, BigDecimal equityCapital, String comment, String mangUser, String loanStatus) {
      this.loanId = loanId;
      this.contractNo = contractNo;
      this.borrOwer = borrOwer;
      this.lender = lender;
      this.usedCap = usedCap;
      this.contractType = contractType;
      this.projectName = projectName;
      this.loanName = loanName;
      this.loanAmount = loanAmount;
      this.ccy = ccy;
      this.interestRate1 = interestRate1;
      this.descriptionInterestRate = descriptionInterestRate;
      this.fee1 = fee1;
      this.fee2 = fee2;
      this.fee3 = fee3;
      this.loanPeriod = loanPeriod;
      this.fromDate = fromDate;
      this.endDate = endDate;
      this.equityCapital = equityCapital;
      this.comment = comment;
      this.mangUser = mangUser;
      this.loanStatus = loanStatus;
   }
}
