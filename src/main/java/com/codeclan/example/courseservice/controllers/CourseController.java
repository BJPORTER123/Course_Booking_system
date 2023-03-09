package com.codeclan.example.courseservice.controllers;

import com.codeclan.example.courseservice.models.Course;
import com.codeclan.example.courseservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name = "starRating", required = false)Integer starRating,
            @RequestParam(name = "customerName", required = false)String name
    ){
        if (starRating != null){
            return new ResponseEntity<>(courseRepository.findByStarRating(starRating), HttpStatus.OK);
        }
        if (name != null){
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerName(name), HttpStatus.OK);
        }
    return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
}
