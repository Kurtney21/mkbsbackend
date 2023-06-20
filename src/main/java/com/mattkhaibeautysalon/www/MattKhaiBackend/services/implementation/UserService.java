package com.mattkhaibeautysalon.www.MattKhaiBackend.services.implementation;

import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.User;
import com.mattkhaibeautysalon.www.MattKhaiBackend.repository.UserRepository;
import com.mattkhaibeautysalon.www.MattKhaiBackend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService implements IServices<User, Long> {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User User) {
        return repository.save(User);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User update(Long id, User updatedUser) {
        User existingUser = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found: "+id));

        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhone(updatedUser.getPhone());

        return repository.save(existingUser);
    }

    public Optional<User> findUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
