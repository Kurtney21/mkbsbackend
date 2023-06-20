package com.mattkhaibeautysalon.www.MattKhaiBackend.repository;

import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findUserByEmailAndPassword(String email, String password);
}
