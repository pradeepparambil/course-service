package com.teksenz.courseservice.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@ToString(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Course extends BaseEntity{
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Float fee;
    @Column(nullable = false)
    private Timestamp startDate;
    @Column(nullable = false)
    private Timestamp expectedEndDate;
    @Column(nullable = false)
    private CourseState courseState;
    @OneToMany(mappedBy = "course")
    private List<FeePaymentSchedule> feePaymentSchedules;
    @Builder
    public Course(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String title, String description, Float fee, Timestamp startDate, Timestamp expectedEndDate, CourseState courseState, List<FeePaymentSchedule> feePaymentSchedules) {
        super(id, version, createdDate, lastModifiedDate);
        this.title = title;
        this.description = description;
        this.fee = fee;
        this.startDate = startDate;
        this.expectedEndDate = expectedEndDate;
        this.courseState = courseState;
        this.feePaymentSchedules = feePaymentSchedules;
    }
}
