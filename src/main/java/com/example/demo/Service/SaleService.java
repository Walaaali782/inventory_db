package com.example.demo.Service;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
	 @Autowired
	    private SaleRepository saleRepository;

	    public List<Sale> getAllSales() {
	        return saleRepository.findAll();
	    }

	    public Optional<Sale> getSaleById(Long id) {
	        return saleRepository.findById(id);
	    }

	    public Sale saveSale(Sale sale) {
	        return saleRepository.save(sale);
	    }

	    public void deleteSale(Long id) {
	        saleRepository.deleteById(id);
	    }
	}