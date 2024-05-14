package com.selfstudy.accounts.entity;

import com.selfstudy.accounts.audit.AuditAwareImpl;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.Date;


@MappedSuperclass
@Getter @Setter @ToString
@EntityListeners(AuditAwareImpl.class)
public class BaseEntity {
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;
    @CreatedBy
    @Column(updatable = false)
    private String CreatedBy;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date updatedAt;
    @LastModifiedBy
    @Column(updatable = false)
    private String updatedBy;
}
