package com.mattkhaibeautysalon.www.MattKhaiBackend.controller;

import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.Customer;
import com.mattkhaibeautysalon.www.MattKhaiBackend.services.implementation.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.lang.annotation.Repeatable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @RequestMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody @Validated Customer customer){
        try {
            return new ResponseEntity<Customer>(service.create(customer), HttpStatus.CREATED);
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> customers = service.findAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id){
        Optional<Customer> customer = service.findCustomerById(id);
        return customer.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update-customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        Customer updatedCustomer = service.update(id, customer);
        return updatedCustomer != null ? ResponseEntity.ok(updatedCustomer) : ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        boolean deleted = service.delete(id);
        return deleted ? ResponseEntity.notFound().build() : ResponseEntity.notFound().build();
    }
}
