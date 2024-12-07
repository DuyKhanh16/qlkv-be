package org.example.qlkv.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCustomDto {
    private String name;
    private String abbreviation;
    private String address;
    private String busRegist;
    private String mangUser;  // loginData.loginName
    private String inputedDate;
    private String inputedUser; // loginData.loginName
    private BigDecimal charterCapital;
    private BigDecimal recentRevenue;
    private BigDecimal recentProfit;
    private String cusAccountNumber;
    private int customerType;
    private int gender;
    private String dateOfBirth;
    private String dateOfIssue;
    private String placeOfIssue;
    private String phone;
    private String email;
    private String bankName;
}
