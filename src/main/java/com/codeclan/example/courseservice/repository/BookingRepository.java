package com.codeclan.example.courseservice.repository;

import com.codeclan.example.courseservice.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByDate(String date);

}
