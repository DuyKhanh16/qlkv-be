package org.example.qlkv.DTO.response;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ProjectDTO {
    private int id;
    private String projectNo;
    private String projectName;
    private String name; // Corresponds to c.name
    private String nameType; // Corresponds to t.typeDesc
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal budget;
    private String ccy;
    private String legalRecord;
    private BigDecimal recentValue;
    private BigDecimal quantity;
    private String projectLocation;
    private String unit;
    private String description;
    private String status;



    // All-args constructor
    public ProjectDTO(int id, String projectNo, String projectName, String name, String nameType,
                      LocalDate startDate, LocalDate endDate, BigDecimal budget, String ccy, String legalRecord,
                      BigDecimal recentValue, BigDecimal quantity, String projectLocation, String unit,
                      String description, String status) {
        this.id = id;
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.name = name;
        this.nameType = nameType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.ccy = ccy;
        this.legalRecord = legalRecord;
        this.recentValue = recentValue;
        this.quantity = quantity;
        this.projectLocation = projectLocation;
        this.unit = unit;
        this.description = description;
        this.status = status;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getLegalRecord() {
        return legalRecord;
    }

    public void setLegalRecord(String legalRecord) {
        this.legalRecord = legalRecord;
    }

    public BigDecimal getRecentValue() {
        return recentValue;
    }

    public void setRecentValue(BigDecimal recentValue) {
        this.recentValue = recentValue;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
