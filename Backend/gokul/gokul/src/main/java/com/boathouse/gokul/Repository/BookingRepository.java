package com.boathouse.gokul.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boathouse.gokul.Model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    
}
