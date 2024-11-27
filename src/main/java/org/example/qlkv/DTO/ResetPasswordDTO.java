package org.example.qlkv.DTO;

import lombok.Data;

@Data
public class ResetPasswordDTO {
    private String loginName;
    private String newPassword;
}
