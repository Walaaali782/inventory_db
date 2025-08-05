package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.StockMovement;


public interface StockMovementRepository extends JpaRepository<StockMovement, Long>  {
	
}