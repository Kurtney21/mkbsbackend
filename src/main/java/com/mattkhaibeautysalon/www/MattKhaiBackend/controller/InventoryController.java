package com.mattkhaibeautysalon.www.MattKhaiBackend.controller;

import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.Inventory;
import com.mattkhaibeautysalon.www.MattKhaiBackend.services.implementation.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {

    private final InventoryService service;

    @Autowired
    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Inventory> createInventory(@RequestBody @Validated Inventory inventory) {
        try {
            return new ResponseEntity<>(service.create(inventory), HttpStatus.CREATED);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Inventory>> getAllInventories() {
        List<Inventory> inventories = service.findAll();
        return ResponseEntity.ok(inventories);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Inventory> findInventoryById(@PathVariable Long id) {
        Optional<Inventory> inventory = service.findInventoryById(id);
        return inventory.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update-inventory/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable Long id, @RequestBody Inventory inventory) {
        Inventory updatedInventory = service.update(id, inventory);
        return updatedInventory != null ? ResponseEntity.ok(updatedInventory) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
