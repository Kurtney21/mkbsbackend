package com.mattkhaibeautysalon.www.MattKhaiBackend.repository;

import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
