package com.mattkhaibeautysalon.www.MattKhaiBackend.services.implementation;

import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.Inventory;
import com.mattkhaibeautysalon.www.MattKhaiBackend.repository.InventoryRepository;
import com.mattkhaibeautysalon.www.MattKhaiBackend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class InventoryService implements IServices<Inventory, Long> {

    private final InventoryRepository repository;

    @Autowired
    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Inventory create(Inventory inventory) {
        return repository.save(inventory);
    }

    @Override
    public List<Inventory> findAll() {
        return repository.findAll();
    }

    @Override
    public Inventory update(Long id, Inventory inventory) {
        Inventory existingInventory = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Inventory not found: " + id));

        existingInventory.setName(inventory.getName());
        existingInventory.setQuantity(inventory.getQuantity());

        return repository.save(existingInventory);
    }

    public Optional<Inventory> findInventoryById(Long id) {
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
