package com.boathouse.gokul.Service;

import java.util.List;

import com.boathouse.gokul.dto.BookingDTO;

public interface BookingService {
    BookingDTO createBooking(BookingDTO bookingDTO);

    BookingDTO getBookingById(Long id);

    List<BookingDTO> getAllBookings();
}
