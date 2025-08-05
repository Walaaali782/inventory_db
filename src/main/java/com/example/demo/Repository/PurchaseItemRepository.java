package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.PurchaseItem;



public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long>  {
	
}