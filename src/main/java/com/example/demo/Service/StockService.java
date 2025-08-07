package com.example.demo.Service;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {
	  @Autowired
	    private StockRepository stockRepository;

	    public List<Stock> getAllStocks() {
	        return stockRepository.findAll();
	    }

	    public Optional<Stock> getStockById(Long id) {
	        return stockRepository.findById(id);
	    }

	    public Stock saveStock(Stock stock) {
	        return stockRepository.save(stock);
	    }

	    public void deleteStock(Long id) {
	        stockRepository.deleteById(id);
	    }
	}