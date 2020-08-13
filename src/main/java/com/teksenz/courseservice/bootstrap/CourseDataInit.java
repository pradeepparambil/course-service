package com.teksenz.courseservice.bootstrap;

import com.teksenz.courseservice.domain.Course;
import com.teksenz.courseservice.domain.CourseState;
import com.teksenz.courseservice.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Slf4j
@RequiredArgsConstructor
public class CourseDataInit implements CommandLineRunner {
    private final CourseRepository courseRepository;
    @Override
    public void run(String... args) throws Exception {
        if(courseRepository.count() == 0){
            loadCourses();
        }

    }

    private void loadCourses() {
        Course courseBatch20 = Course.builder()
                .title("Fullstack Automation - Batch20")
                .description("Fullstack automation - Java, Selenium, RestAssured, SQL, Maven, Agile")
                .fee(2000f)
                .courseState(CourseState.ENROLLMENT)
                .startDate(Timestamp.valueOf("2020-12-01 09:01:15"))
                .expectedEndDate(Timestamp.valueOf("2021-04-01 09:01:15"))
                .build();
        Course courseBatch19 = Course.builder()
                .title("Fullstack Automation - Batch19")
                .description("Fullstack automation - Java, Selenium, RestAssured, SQL, Maven, Agile")
                .fee(2000f)
                .courseState(CourseState.IN_PROGRESS)
                .startDate(Timestamp.valueOf("2020-12-01 09:01:15"))
                .expectedEndDate(Timestamp.valueOf("2021-04-01 09:01:15"))
                .build();

        Course courseBatch18 = Course.builder()
                .title("Fullstack Automation - Batch18")
                .description("Fullstack automation - Java, Selenium, RestAssured, SQL, Maven, Agile")
                .fee(2000f)
                .courseState(CourseState.COMPLETED)
                .startDate(Timestamp.valueOf("2020-12-01 09:01:15"))
                .expectedEndDate(Timestamp.valueOf("2021-04-01 09:01:15"))
                .build();
        courseRepository.save(courseBatch18);
        courseRepository.save(courseBatch19);
        courseRepository.save(courseBatch20);

        log.info(String.valueOf("Number of courses : "+courseRepository.count()));

    }
}
