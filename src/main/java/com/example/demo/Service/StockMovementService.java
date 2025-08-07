package com.example.demo.Service;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockMovementService {
	  @Autowired
	    private StockMovementRepository stockMovementRepository;

	    public List<StockMovement> getAllStockMovements() {
	        return stockMovementRepository.findAll();
	    }

	    public Optional<StockMovement> getStockMovementById(Long id) {
	        return stockMovementRepository.findById(id);
	    }

	    public StockMovement saveStockMovement(StockMovement movement) {
	        return stockMovementRepository.save(movement);
	    }

	    public void deleteStockMovement(Long id) {
	        stockMovementRepository.deleteById(id);
	    }
	}
