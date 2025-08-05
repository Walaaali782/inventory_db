package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.SaleItem;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long>  {
	
}