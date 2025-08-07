package com.example.demo.Service;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseItemService {
	  @Autowired
	    private PurchaseItemRepository purchaseItemRepository;

	    public List<PurchaseItem> getAllPurchaseItems() {
	        return purchaseItemRepository.findAll();
	    }

	    public Optional<PurchaseItem> getPurchaseItemById(Long id) {
	        return purchaseItemRepository.findById(id);
	    }

	    public PurchaseItem savePurchaseItem(PurchaseItem item) {
	        return purchaseItemRepository.save(item);
	    }

	    public void deletePurchaseItem(Long id) {
	        purchaseItemRepository.deleteById(id);
	    }
	}