package com.example.demo.Service;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
	 @Autowired
	    private PurchaseRepository purchaseRepository;

	    public List<Purchase> getAllPurchases() {
	        return purchaseRepository.findAll();
	    }

	    public Optional<Purchase> getPurchaseById(Long id) {
	        return purchaseRepository.findById(id);
	    }

	    public Purchase savePurchase(Purchase purchase) {
	        return purchaseRepository.save(purchase);
	    }

	    public void deletePurchase(Long id) {
	        purchaseRepository.deleteById(id);
	    }
	}