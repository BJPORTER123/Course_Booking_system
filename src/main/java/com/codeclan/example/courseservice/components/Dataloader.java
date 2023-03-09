package com.codeclan.example.courseservice.components;

import com.codeclan.example.courseservice.models.Booking;
import com.codeclan.example.courseservice.models.Course;
import com.codeclan.example.courseservice.models.Customer;
import com.codeclan.example.courseservice.repository.BookingRepository;
import com.codeclan.example.courseservice.repository.CourseRepository;
import com.codeclan.example.courseservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Component;

@Profile("!test")
//@Component
public class Dataloader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public Dataloader() {
    }

    public void run(ApplicationArguments args){
        Course course = new Course("Yoga", "Edinburgh", 4 );
        courseRepository.save(course);
        Course course2 = new Course("Python", "Dundee", 5 );
        courseRepository.save(course2);
        Course course3 = new Course("Java", "Glasgow", 2);
        courseRepository.save(course3);

        Customer customer = new Customer("Charlotte", "Edinburgh", 22);
        customerRepository.save(customer);
        Customer customer2  = new Customer("Kosta", "Kyiv", 39);
        customerRepository.save(customer2);
        Customer customer3 = new Customer("Ben", "Dundee", 21);
        customerRepository.save(customer3);

        Booking booking = new Booking("12-02-23", course, customer);
        bookingRepository.save(booking);
        Booking booking2 = new Booking("14-05-23", course2, customer2);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("05-10-23", course3, customer3);
        bookingRepository.save(booking3);

    }
}
