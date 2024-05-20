package com.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.model.Inventory;

@Repository
public interface InventoryRepository1 extends JpaRepository<Inventory,Long>{

}
