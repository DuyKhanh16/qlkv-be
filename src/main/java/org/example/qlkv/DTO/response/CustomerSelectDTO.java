package org.example.qlkv.DTO.response;

import lombok.Data;

@Data
public class CustomerSelectDTO {
    private int id;
    private String name;
    private  String abbreviation;

    public CustomerSelectDTO(int id,String name, String abbreviation) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
    }
}
