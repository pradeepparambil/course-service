package com.teksenz.courseservice.web.mapper;

import com.teksenz.courseservice.domain.Course;
import com.teksenz.courseservice.domain.CourseState;
import com.teksenz.courseservice.web.model.CourseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@ExtendWith(MockitoExtension.class)
class CourseMapperTest {
    @InjectMocks
    private CourseMapperImpl courseMapper;
    @Mock
    private DateMapper dateMapper;

    private Course getCourse(){
        return Course.builder()
                .title("Fullstack Automation - Batch20")
                .description("Fullstack automation - Java, Selenium, RestAssured, SQL, Maven, Agile")
                .fee(2000f)
                .courseState(CourseState.ENROLLMENT)
                .startDate(Timestamp.valueOf("2020-12-01 09:01:15"))
                .expectedEndDate(Timestamp.valueOf("2021-04-01 09:01:15"))
                .build();
    }
    private CourseDto getCourseDto(){
        return CourseDto.builder()
                .title("Fullstack Automation - Batch20")
                .description("Fullstack automation - Java, Selenium, RestAssured, SQL, Maven, Agile")
                .fee(2000f)
                .courseState(CourseState.ENROLLMENT)
                .startDate(OffsetDateTime.now())
                .expectedEndDate(OffsetDateTime.now())
                .build();
    }

    @Test
    void courseToDto() {
        assertNotNull(courseMapper.courseToDto(getCourse()));
    }

    @Test
    void dtoToCourse() {
        assertNotNull(courseMapper.dtoToCourse(getCourseDto()));
    }
}