package com.mattkhaibeautysalon.www.MattKhaiBackend.controller;

import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.Booking;
import com.mattkhaibeautysalon.www.MattKhaiBackend.services.implementation.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService service;

    @Autowired
    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody @Validated Booking booking) {
        try {
            return new ResponseEntity<>(service.create(booking), HttpStatus.CREATED);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = service.findAll();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Booking> findBookingById(@PathVariable Long id) {
        Optional<Booking> booking = service.findBookingById(id);
        return booking.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update-booking/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        Booking updatedBooking = service.update(id, booking);
        return updatedBooking != null ? ResponseEntity.ok(updatedBooking) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
