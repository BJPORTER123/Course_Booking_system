package com.codeclan.example.courseservice.repository;

import com.codeclan.example.courseservice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByStarRating(Integer rating);
    List<Course> findByBookingsCustomerName(String name);
}
