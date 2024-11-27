package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "QLNDStatusDefinition")
@Data
public class QLNDStatusDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Status")
    private String status;

    @Column(name = "Description")
    private int description;
}
