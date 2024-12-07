package org.example.qlkv.DTO;

import lombok.Data;

@Data
public class UserLoginResponsi {
    private String loginName;
    private String fullName;
    private String password;
    private String Name;


    public UserLoginResponsi(String loginName,String fullName, String password, String Name) {
        this.loginName = loginName;
        this.fullName = fullName;
        this.password = password;
        this.Name = Name;
    }
}
