package com.teksenz.courseservice.services;


import com.teksenz.courseservice.web.model.CourseDto;
import com.teksenz.courseservice.web.model.CoursePagedList;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;


public interface CourseService {
    CoursePagedList getCourseList(String courseState, PageRequest of);

    CourseDto findCourseById(UUID id);
}
