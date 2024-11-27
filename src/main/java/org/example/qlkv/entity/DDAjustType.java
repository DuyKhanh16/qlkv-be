package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "DDAjustType")
public class DDAjustType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Description")
    private String description;

    @Column(name = "InputedDate")
    private LocalDateTime inputedDate;

    @Column(name = "InputedUser")
    private String inputedUser;
}
