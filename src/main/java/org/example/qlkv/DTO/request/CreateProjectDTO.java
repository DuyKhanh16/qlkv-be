package org.example.qlkv.DTO.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class CreateProjectDTO {
    private int id;
    private int projectTypeId;
    private int projectOwnerId;
    private String projectName;
    private String startDate;
    private String endDate;
    private BigDecimal budget;
    private String description;
    private String status;
    private String projectOwner;
    private String disbursers;
    private String mangUser;
    private LocalDateTime inputedDate;
    private String inputedUser;
    private String projectLocation;
    private String legalRecord;
    private BigDecimal recentValue;
    private String projectNo;
    private String ccy;
    private BigDecimal quantity;
    private String unit;
}
