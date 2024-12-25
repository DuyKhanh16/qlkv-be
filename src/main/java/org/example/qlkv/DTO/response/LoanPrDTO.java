package org.example.qlkv.DTO.response;

import lombok.Data;

@Data
public class LoanPrDTO {
    private int id;
    private String purposeName;

    public LoanPrDTO(int id, String purposeName) {
        this.id = id;
        this.purposeName = purposeName;
    }
}
