package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "QLNDScope")
@Data
public class QLNDScope {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "AppCode")
    private String appCode;

    @Column(name = "ModuleCode")
    private String moduleCode;

    @Column(name = "ItemId")
    private int itemId;
}
