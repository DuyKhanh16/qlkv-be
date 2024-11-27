package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "CollateralType")
@Data
public class CollateralType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Tự động tăng ID
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Description", columnDefinition = "nvarchar(max)", nullable = true)
    private String description;

    @Column(name = "InputedDate", nullable = true)
    private LocalDateTime inputedDate;

    @Column(name = "InputedUser", length = 50, nullable = true)
    private String inputedUser;

    @Column(name = "CollateralTypeNo", length = 50, nullable = true)
    private String collateralTypeNo;

}
