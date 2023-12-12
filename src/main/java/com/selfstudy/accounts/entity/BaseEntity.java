package com.selfstudy.accounts.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter @ToString
public class BaseEntity {
    private LocalDateTime createdAt;
    private String CreatedBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
