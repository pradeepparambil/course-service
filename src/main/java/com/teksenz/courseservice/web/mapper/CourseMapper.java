package com.teksenz.courseservice.web.mapper;

import com.teksenz.courseservice.domain.Course;
import com.teksenz.courseservice.web.model.CourseDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface CourseMapper{
    CourseDto courseToDto(Course course);
    Course dtoToCourse(CourseDto courseDto);
}
