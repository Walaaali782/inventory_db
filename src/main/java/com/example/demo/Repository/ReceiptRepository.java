package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Receipt;


public interface ReceiptRepository extends JpaRepository<Receipt, Long>  {
	
}