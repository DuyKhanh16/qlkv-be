package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "QLNDUserGroup")
public class QLNDUserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "UserId")
    private String userId;

    @Column(name = "GroupId")
    private String groupId;
}
