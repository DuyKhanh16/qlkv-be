package org.example.qlkv.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateUserDTO {
    @NotEmpty(message = "Không được để trống tên đăng nhập")
    private String loginName;

    @NotEmpty(message = "Không được để trống mật khẩu")
    private String password;

    @NotEmpty(message = "Không được để trống Tên")
    private String fullName;

    @NotEmpty(message = "Không được để trống tên đơn vị")
    private String department;

    @NotEmpty(message = "Không được để trống người quản lý")
    private String mangUser;
}
