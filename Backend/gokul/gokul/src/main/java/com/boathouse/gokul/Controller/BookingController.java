package com.boathouse.gokul.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.boathouse.gokul.Model.Booking;
import com.boathouse.gokul.Service.BookingService;
import com.boathouse.gokul.dto.BoatDTO;
import com.boathouse.gokul.dto.BookingDTO;

import io.micrometer.core.ipc.http.HttpSender;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@AllArgsConstructor
// @CrossOrigin
@RestController
// @RequestMapping("/booking")
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
public class BookingController {
    private BookingService bookingService;

    @PostMapping("/add")
    public ResponseEntity<BookingDTO> postBooking(@RequestBody BookingDTO bookingDTO) {
        BookingDTO savedBook = bookingService.createBooking(bookingDTO);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookingDTO> getBooking(@PathVariable("id") Long id) {
        BookingDTO bookingDTO = bookingService.getBookingById(id);
        return ResponseEntity.ok(bookingDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<BookingDTO>> getAllBooking() {
        List<BookingDTO> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
    
    
    
}
