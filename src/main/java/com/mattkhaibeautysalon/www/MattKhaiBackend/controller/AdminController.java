package com.mattkhaibeautysalon.www.MattKhaiBackend.controller;

import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.Admin;
import com.mattkhaibeautysalon.www.MattKhaiBackend.services.implementation.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminService service;

    @Autowired
    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@RequestBody @Validated Admin admin) {
        try {
            return new ResponseEntity<>(service.create(admin), HttpStatus.CREATED);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = service.findAll();
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Admin> findAdminById(@PathVariable Long id) {
        Optional<Admin> admin = service.findAdminById(id);
        return admin.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update-admin/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        Admin updatedAdmin = service.update(id, admin);
        return updatedAdmin != null ? ResponseEntity.ok(updatedAdmin) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
