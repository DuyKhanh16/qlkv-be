package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "QLNDGroup")
public class QLNDGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;
}
