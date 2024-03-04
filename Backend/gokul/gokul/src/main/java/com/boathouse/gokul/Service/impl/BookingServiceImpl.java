package com.boathouse.gokul.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.boathouse.gokul.Exception.ResourceNotFoundException;
import com.boathouse.gokul.Mapper.BoatMapper;
import com.boathouse.gokul.Mapper.BookingMapper;
import com.boathouse.gokul.Model.Boat;
import com.boathouse.gokul.Model.Booking;
import com.boathouse.gokul.Repository.BookingRepository;
import com.boathouse.gokul.Service.BookingService;
import com.boathouse.gokul.dto.BoatDTO;
import com.boathouse.gokul.dto.BookingDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO){
        Booking booking = BookingMapper.mapToBooking(bookingDTO);
        Booking savedBooking = bookingRepository.save(booking);
        return BookingMapper.mapToBookingDTO(savedBooking);
    }

    @Override
    public BookingDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                    .orElseThrow(
                        () -> new ResourceNotFoundException("user is not exist with given email : " +  id));
        return BookingMapper.mapToBookingDTO(booking);       
    }

    @Override
    public List<BookingDTO> getAllBookings() {
       List<Booking> bookings = bookingRepository.findAll();
       List<BookingDTO> bookingDTOs = new ArrayList<>();
       for(Booking booking : bookings){
            bookingDTOs.add(BookingMapper.mapToBookingDTO(booking));
       }
       return bookingDTOs;
    }
}
