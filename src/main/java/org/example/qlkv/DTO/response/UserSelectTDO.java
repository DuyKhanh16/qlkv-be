package org.example.qlkv.DTO.response;

import lombok.Data;

@Data
public class UserSelectTDO {
    private String loginName;
    private String fullName;

    public UserSelectTDO(String loginName, String fullName ) {
        this.loginName = loginName;
        this.fullName = fullName;
    }
}
