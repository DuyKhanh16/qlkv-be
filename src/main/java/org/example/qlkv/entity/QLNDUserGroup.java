package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "QLNDUserGroup")
public class QLNDUserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Column(name = "UserId")
    private UUID userId;

    @Column(name = "GroupId")
    private UUID groupId;

    public void getGroupId(UUID roleUser) {

    }
}
