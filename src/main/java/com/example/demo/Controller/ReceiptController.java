package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Receipt;
import com.example.demo.Service.ReceiptService;






@RestController
@RequestMapping("/api/receipts")
public class ReceiptController {
    @Autowired
    private ReceiptService service;

    @GetMapping
    public List<Receipt> getAll() {
        return service.getAllReceipts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receipt> getById(@PathVariable Long id) {
        return service.getReceiptById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Receipt create(@RequestBody Receipt receipt) {
        return service.saveReceipt(receipt);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receipt> update(@PathVariable Long id, @RequestBody Receipt updated) {
        return service.getReceiptById(id)
                .map(existing -> {
                    existing.setCustomer(updated.getCustomer());
                    existing.setSale(updated.getSale());
                    existing.setUser(updated.getUser());
                    existing.setDate(updated.getDate());
                    existing.setAmount(updated.getAmount());
                    return ResponseEntity.ok(service.saveReceipt(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteReceipt(id);
    }
}
