package org.example.qlkv.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserLoginDTO {
    @NotEmpty(message = "không được để trống tên đăng nhập")
    private String loginName;

    @NotEmpty(message = "không được để tống mật khẩu")
    private String password;
}
