package org.example.qlkv.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Collateral")
public class Collateral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Tự động tăng ID
    @Column(name = "ID", nullable = false)  // Không cho phép null
    private Integer id;

    @Column(name = "CollNo", length = 50, nullable = true)
    private String collNo;

    @Column(name = "LenderID", nullable = true)
    private Integer lenderId;

    @Column(name = "CollTypeID", nullable = true)
    private Integer collTypeId;

    @Column(name = "ProjectID", nullable = true)
    private Integer projectId;

    @Column(name = "Description", columnDefinition = "nvarchar(max)", nullable = true)
    private String description;

    @Column(name = "CCY", length = 50, nullable = true)
    private String ccy;

    @Column(name = "NominalValue", precision = 18, scale = 0, nullable = true)
    private BigDecimal nominalValue;

    @Column(name = "ExcutionValue", precision = 18, scale = 0, nullable = true)
    private BigDecimal excutionValue;

    @Column(name = "InputedDate", nullable = true)
    private LocalDateTime inputedDate;

    @Column(name = "InputedUser", length = 50, nullable = true)
    private String inputedUser;

    @Column(name = "MaturityDate", nullable = true)
    private LocalDate maturityDate;

    @Column(name = "Status", length = 50, nullable = true)
    private String status;

    @Column(name = "Quantity", precision = 18, scale = 0, nullable = true)
    private BigDecimal quantity;

    @Column(name = "Unit", length = 255, nullable = true)
    private String unit;

    @Column(name = "ExcutionPerUnit", precision = 18, scale = 0, nullable = true)
    private BigDecimal excutionPerUnit;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollNo() {
        return collNo;
    }

    public void setCollNo(String collNo) {
        this.collNo = collNo;
    }

    public Integer getLenderId() {
        return lenderId;
    }

    public void setLenderId(Integer lenderId) {
        this.lenderId = lenderId;
    }

    public Integer getCollTypeId() {
        return collTypeId;
    }

    public void setCollTypeId(Integer collTypeId) {
        this.collTypeId = collTypeId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public BigDecimal getNominalValue() {
        return nominalValue;
    }

    public void setNominalValue(BigDecimal nominalValue) {
        this.nominalValue = nominalValue;
    }

    public BigDecimal getExcutionValue() {
        return excutionValue;
    }

    public void setExcutionValue(BigDecimal excutionValue) {
        this.excutionValue = excutionValue;
    }

    public LocalDateTime getInputedDate() {
        return inputedDate;
    }

    public void setInputedDate(LocalDateTime inputedDate) {
        this.inputedDate = inputedDate;
    }

    public String getInputedUser() {
        return inputedUser;
    }

    public void setInputedUser(String inputedUser) {
        this.inputedUser = inputedUser;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getExcutionPerUnit() {
        return excutionPerUnit;
    }

    public void setExcutionPerUnit(BigDecimal excutionPerUnit) {
        this.excutionPerUnit = excutionPerUnit;
    }
}
