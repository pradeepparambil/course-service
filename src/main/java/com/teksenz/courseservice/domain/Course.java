package com.teksenz.courseservice.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class Course extends BaseEntity{
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Float fee;
    @Column(nullable = false)
    private Timestamp startDate;
    @Column(nullable = false)
    private Timestamp expectedEndDate;
    @Column(nullable = false)
    private CourseState courseState;

    @Builder
    public Course(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String title, Float fee, Timestamp startDate, Timestamp expectedEndDate, CourseState courseState) {
        super(id, version, createdDate, lastModifiedDate);
        this.title = title;
        this.fee = fee;
        this.startDate = startDate;
        this.expectedEndDate = expectedEndDate;
        this.courseState = courseState;
    }
}
