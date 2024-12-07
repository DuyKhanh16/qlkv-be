package org.example.qlkv.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "CollateralRight")
public class CollateralRight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "CollID", nullable = true)
    private Integer collId;

    @Column(name = "LoanID", nullable = true)
    private Integer loanId;

    @Column(name = "AmountAllocate", precision = 18, scale = 0, nullable = true)
    private BigDecimal amountAllocate;

    @Column(name = "Status", length = 50, nullable = true)
    private String status;

    @Column(name = "Amount", precision = 18, scale = 0, nullable = true)
    private BigDecimal amount;

    @Column(name = "Unit", length = 50, nullable = true)
    private String unit;

    @Column(name = "CCY", length = 10, nullable = true)
    private String ccy;

    @Column(name = "FromDate", nullable = true)
    private LocalDate fromDate;

    @Column(name = "EndDate", nullable = true)
    private LocalDate endDate;

    @Column(name = "InputedUser", length = 50, nullable = true)
    private String inputedUser;

    @Column(name = "InputedDate", nullable = true)
    private LocalDateTime inputedDate;

    @Column(name = "CreditRatio", precision = 18, scale = 0, nullable = true)
    private BigDecimal creditRatio;

    @Column(name = "CollRightNo", length = 50, nullable = true)
    private String collRightNo;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCollId() {
        return collId;
    }

    public void setCollId(Integer collId) {
        this.collId = collId;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public BigDecimal getAmountAllocate() {
        return amountAllocate;
    }

    public void setAmountAllocate(BigDecimal amountAllocate) {
        this.amountAllocate = amountAllocate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getInputedUser() {
        return inputedUser;
    }

    public void setInputedUser(String inputedUser) {
        this.inputedUser = inputedUser;
    }

    public LocalDateTime getInputedDate() {
        return inputedDate;
    }

    public void setInputedDate(LocalDateTime inputedDate) {
        this.inputedDate = inputedDate;
    }

    public BigDecimal getCreditRatio() {
        return creditRatio;
    }

    public void setCreditRatio(BigDecimal creditRatio) {
        this.creditRatio = creditRatio;
    }

    public String getCollRightNo() {
        return collRightNo;
    }

    public void setCollRightNo(String collRightNo) {
        this.collRightNo = collRightNo;
    }
}
