package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Purchase;


public interface PurchaseRepository extends JpaRepository<Purchase, Long>  {
	
}