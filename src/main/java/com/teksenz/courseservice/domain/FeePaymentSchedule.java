package com.teksenz.courseservice.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class FeePaymentSchedule extends BaseEntity{
    @Column(nullable = false)
    private Integer installmentNo;
    @Column(nullable = false)
    private Timestamp dueDate;
    @Column(nullable = false)
    @ManyToOne
    private Course course;
    @Builder
    public FeePaymentSchedule(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, Integer installmentNo, Timestamp dueDate, Course course) {
        super(id, version, createdDate, lastModifiedDate);
        this.installmentNo = installmentNo;
        this.dueDate = dueDate;
        this.course = course;
    }
}
