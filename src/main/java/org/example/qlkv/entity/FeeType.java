package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "FeeType")
public class FeeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Description")
    private String description;

    @Column(name = "InputedDate")
    private Date inputedDate;

    @Column(name = "inputedUser")
    private String inputedUser;
}
