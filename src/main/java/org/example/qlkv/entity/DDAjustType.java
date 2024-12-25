package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "DDAjustType")
public class DDAjustType {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "Description")
    private String description;

    @Column(name = "InputedDate")
    private LocalDateTime inputedDate;

    @Column(name = "InputedUser")
    private String inputedUser;
}
