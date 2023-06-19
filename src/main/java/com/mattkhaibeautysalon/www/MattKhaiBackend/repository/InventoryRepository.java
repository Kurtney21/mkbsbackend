package com.mattkhaibeautysalon.www.MattKhaiBackend.repository;

import com.mattkhaibeautysalon.www.MattKhaiBackend.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
