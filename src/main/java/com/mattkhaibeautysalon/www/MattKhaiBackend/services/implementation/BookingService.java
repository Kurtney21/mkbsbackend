package com.mattkhaibeautysalon.www.MattKhaiBackend.services.implementation;

import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.Booking;
import com.mattkhaibeautysalon.www.MattKhaiBackend.repository.BookingRepository;
import com.mattkhaibeautysalon.www.MattKhaiBackend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookingService implements IServices<Booking, Long> {

    private final BookingRepository repository;

    @Autowired
    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Booking create(Booking booking) {
        return repository.save(booking);
    }

    @Override
    public List<Booking> findAll() {
        return repository.findAll();
    }

    @Override
    public Booking update(Long id, Booking booking) {
        Booking existingBooking = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Booking not found: " + id));

        existingBooking.setDate(booking.getDate());
        existingBooking.setTime(booking.getTime());
        existingBooking.setStatus(booking.getStatus());
        existingBooking.setCustomer(booking.getCustomer());

        return repository.save(existingBooking);
    }

    public Optional<Booking> findBookingById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
