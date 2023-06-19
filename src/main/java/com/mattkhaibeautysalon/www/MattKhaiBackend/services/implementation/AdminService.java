package com.mattkhaibeautysalon.www.MattKhaiBackend.services.implementation;

import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.Admin;
import com.mattkhaibeautysalon.www.MattKhaiBackend.repository.AdminRepository;
import com.mattkhaibeautysalon.www.MattKhaiBackend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AdminService implements IServices<Admin, Long> {

    private final AdminRepository repository;

    @Autowired
    public AdminService(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public Admin create(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public List<Admin> findAll() {
        return repository.findAll();
    }

    @Override
    public Admin update(Long id, Admin admin) {
        Admin existingAdmin = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Admin not found: " + id));

        existingAdmin.setUser(admin.getUser());

        return repository.save(existingAdmin);
    }

    public Optional<Admin> findAdminById(Long id) {
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
