package com.boathouse.gokul.Mapper;

import com.boathouse.gokul.Model.Booking;
import com.boathouse.gokul.dto.BookingDTO;

public class BookingMapper {
    public static BookingDTO mapToBookingDTO(Booking booking){
        return new BookingDTO(
            booking.getId(),
            booking.getEmail(),
            booking.getBoattype(),
            booking.getBoatId(),
            booking.getDate(),
            booking.getPrice(),
            booking.getTickets(),
            booking.getTprice(),
            booking.getIncharge()
        );
    }

    public static Booking mapToBooking(BookingDTO bookingDTO){
        return new Booking(
            bookingDTO.getId(),
            bookingDTO.getEmail(),
            bookingDTO.getBoattype(),
            bookingDTO.getBoatId(),
            bookingDTO.getDate(),
            bookingDTO.getPrice(),
            bookingDTO.getTickets(),
            bookingDTO.getTprice(),
            bookingDTO.getIncharge()
        );
    }
}
