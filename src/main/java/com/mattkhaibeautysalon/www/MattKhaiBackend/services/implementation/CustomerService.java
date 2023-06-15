package com.mattkhaibeautysalon.www.MattKhaiBackend.services.implementation;

import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.Customer;
import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.User;
import com.mattkhaibeautysalon.www.MattKhaiBackend.repository.CustomerRepository;
import com.mattkhaibeautysalon.www.MattKhaiBackend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerService implements IServices<Customer, Long> {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Customer existingCustomer = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found: "+id));

        User user = existingCustomer.getUser();
        User updatedUser  = customer.getUser();

        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());

        return repository.save(customer);
    }

    public Optional<Customer> findCustomerById(Long id) {
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
