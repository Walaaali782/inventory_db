package com.example.demo.Service;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiptService {
	 @Autowired
	    private ReceiptRepository receiptRepository;

	    public List<Receipt> getAllReceipts() {
	        return receiptRepository.findAll();
	    }

	    public Optional<Receipt> getReceiptById(Long id) {
	        return receiptRepository.findById(id);
	    }

	    public Receipt saveReceipt(Receipt receipt) {
	        return receiptRepository.save(receipt);
	    }

	    public void deleteReceipt(Long id) {
	        receiptRepository.deleteById(id);
	    }
	}
