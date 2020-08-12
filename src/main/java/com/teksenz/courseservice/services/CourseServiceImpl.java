package com.teksenz.courseservice.services;

import com.teksenz.courseservice.domain.Course;
import com.teksenz.courseservice.domain.CourseState;
import com.teksenz.courseservice.repositories.CourseRepository;
import com.teksenz.courseservice.web.mapper.CourseMapper;
import com.teksenz.courseservice.web.model.CoursePagedList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    @Override
    public CoursePagedList getCourseList(String courseState, PageRequest pageRequest) {
        Page<Course> coursePage;
        if(!StringUtils.isEmpty(courseState)){
            coursePage = courseRepository.findAllByCourseState(CourseState.valueOf(courseState),pageRequest);
        }else {
            coursePage = courseRepository.findAll(pageRequest);
        }
        CoursePagedList coursePagedList = new CoursePagedList(coursePage.getContent()
                .stream()
                .map(courseMapper::courseToDto)
                .collect(Collectors.toList()),
                pageRequest,coursePage.getTotalElements());
        return coursePagedList;
    }
}
