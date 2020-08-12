package com.teksenz.courseservice.web.controllers;

import com.teksenz.courseservice.services.CourseService;
import com.teksenz.courseservice.web.model.CoursePagedList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/course", produces = {"application/json"})
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final Integer DEFAULT_PAGE_SIZE = 25;
    private final Integer DEFAULT_PAGE_NO = 0;

    @GetMapping
    public ResponseEntity<CoursePagedList> getCourseList(@RequestParam(required = false) String courseState,
                                                         @RequestParam(required = false) Integer pageNo,
                                                         @RequestParam(required = false) Integer pageSize){
        if(pageSize==null || pageSize<1){
            pageSize = DEFAULT_PAGE_SIZE;
        }
        if(pageNo == null || pageNo <0){
            pageNo = DEFAULT_PAGE_NO;
        }
        CoursePagedList coursePagedList = courseService.getCourseList(courseState, PageRequest.of(pageNo,pageSize));
        return new ResponseEntity<>(coursePagedList, HttpStatus.OK);
    }

}
