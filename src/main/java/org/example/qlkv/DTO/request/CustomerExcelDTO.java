package org.example.qlkv.DTO.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class CustomerExcelDTO {
    private String name;
    private String abbreviation;
    private String address;
    private String busRegist;
    private String mangUser;
    private String inputedUser;
    private BigDecimal charterCapital;
    private BigDecimal recentRevenue;
    private BigDecimal recentProfit;
    private String cusAccountNumber;
    private String customerType; // Nhận kiểu String
    private String gender;
    private String dateOfBirth;
    private String dateOfIssue;
    private String placeOfIssue;
    private String phone;
    private String email;
    private String bankName;
}
