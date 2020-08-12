package com.teksenz.courseservice.repositories;

import com.teksenz.courseservice.domain.Course;
import com.teksenz.courseservice.domain.CourseState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
    List<Course> findAllByCourseState(CourseState courseState);
    Page<Course> findAllByCourseState(CourseState courseState, Pageable pageable);

    List<Course> findAllByTitle(String title);
    Page<Course> findAllByTitle(String title, Pageable pageable);
}

