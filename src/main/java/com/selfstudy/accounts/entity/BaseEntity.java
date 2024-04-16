package com.selfstudy.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.Date;


@MappedSuperclass
@Getter @Setter @ToString
public class BaseEntity {
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;
    @Column(updatable = false)
    private String CreatedBy;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date updatedAt;
    @Column(updatable = false)
    private String updatedBy;
}
