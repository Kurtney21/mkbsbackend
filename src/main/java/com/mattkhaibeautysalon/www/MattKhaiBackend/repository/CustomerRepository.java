package com.mattkhaibeautysalon.www.MattKhaiBackend.repository;

import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
