package com.codeclan.example.courseservice.controllers;

import com.codeclan.example.courseservice.models.Customer;
import com.codeclan.example.courseservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity <List<Customer>> getAllCustomers(
            @RequestParam(name = "courseName", required = false)String name
    ){
        if(name != null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

}
