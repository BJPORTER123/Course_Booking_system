package com.codeclan.example.courseservice.repository;

import com.codeclan.example.courseservice.models.Course;
import com.codeclan.example.courseservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseName(String name);
}
