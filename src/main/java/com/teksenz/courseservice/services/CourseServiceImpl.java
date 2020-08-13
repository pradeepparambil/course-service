package com.teksenz.courseservice.services;

import com.teksenz.courseservice.domain.Course;
import com.teksenz.courseservice.domain.CourseState;
import com.teksenz.courseservice.repositories.CourseRepository;
import com.teksenz.courseservice.web.mapper.CourseMapper;
import com.teksenz.courseservice.web.model.CourseDto;
import com.teksenz.courseservice.web.model.CoursePagedList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.stream.Collectors;
@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    @Cacheable(cacheNames = "courseListCache")
    @Override
    public CoursePagedList getCourseList(String courseState, PageRequest pageRequest) {
        log.info("CourseServiceImpl.getCourseList(String courseState, PageRequest pageRequest) invoked");
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

    @Cacheable(cacheNames = "courseCache", key="#id")
    @Override
    public CourseDto findCourseById(UUID id) {
        log.info("CourseServiceImpl.findCourseById(UUID id) invoked");
        courseRepository.findById(id).orElseThrow(()->new RuntimeException("Course not found - id:"+id));
        return courseMapper.courseToDto(courseRepository.findById(id).get());
    }
}
