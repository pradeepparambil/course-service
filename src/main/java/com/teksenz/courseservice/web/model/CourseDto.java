package com.teksenz.courseservice.web.model;

import com.teksenz.courseservice.domain.CourseState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.OffsetDateTime;
import java.util.UUID;

@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor

public class CourseDto extends BaseDto{
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private Float fee;
    @NotNull
    private OffsetDateTime startDate;
    private OffsetDateTime expectedEndDate;
    private CourseState courseState;

    public CourseDto(@Null UUID id, @Null Long version, @Null OffsetDateTime createdDate, @Null OffsetDateTime lastModifiedDate, String title, String description, Float fee, OffsetDateTime startDate, OffsetDateTime expectedEndDate, CourseState courseState) {
        super(id, version, createdDate, lastModifiedDate);
        this.title = title;
        this.description = description;
        this.fee = fee;
        this.startDate = startDate;
        this.expectedEndDate = expectedEndDate;
        this.courseState = courseState;
    }
}