package com.example.demo.Service;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleItemService {
	  @Autowired
	    private SaleItemRepository saleItemRepository;

	    public List<SaleItem> getAllSaleItems() {
	        return saleItemRepository.findAll();
	    }

	    public Optional<SaleItem> getSaleItemById(Long id) {
	        return saleItemRepository.findById(id);
	    }

	    public SaleItem saveSaleItem(SaleItem item) {
	        return saleItemRepository.save(item);
	    }

	    public void deleteSaleItem(Long id) {
	        saleItemRepository.deleteById(id);
	    }
	}
