package com.mattkhaibeautysalon.www.MattKhaiBackend.repository;

import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
