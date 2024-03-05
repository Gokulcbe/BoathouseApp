package com.sample.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.entity.Booking;



public interface BookingRepository extends JpaRepository<Booking, Long> {
    
}
