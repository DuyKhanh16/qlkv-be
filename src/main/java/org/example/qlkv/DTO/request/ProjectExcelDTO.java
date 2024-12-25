package org.example.qlkv.DTO.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class ProjectExcelDTO {
    private String projectNo;
    private String projectName;
    private String projectType;
    private String startDate;
    private String endDate;
    private String projectLocation;
    private String unit;
    private BigDecimal quantity;
    private String ccy;
    private BigDecimal budget;
    private BigDecimal recentValue;
    private String name;
    private String legalRecord;
    private String description;
    private String status;
}
