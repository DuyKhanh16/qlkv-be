package org.example.qlkv.DTO;

import lombok.Data;

@Data
public class UserLoginResponsi {
    private String fullName;
    private String password;
    private String Name;


    public UserLoginResponsi(String fullName, String password, String Name) {
        this.fullName = fullName;
        this.password = password;
        this.Name = Name;
    }
}
