package com.teksenz.courseservice.services;


import com.teksenz.courseservice.web.model.CoursePagedList;
import org.springframework.data.domain.PageRequest;


public interface CourseService {
    CoursePagedList getCourseList(String courseState, PageRequest of);

}
