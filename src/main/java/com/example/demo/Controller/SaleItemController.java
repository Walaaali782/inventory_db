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

import com.example.demo.Entity.SaleItem;
import com.example.demo.Service.SaleItemService;







@RestController
@RequestMapping("/api/sale-items")
public class SaleItemController {
    @Autowired
    private SaleItemService service;

    @GetMapping
    public List<SaleItem> getAll() {
        return service.getAllSaleItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleItem> getById(@PathVariable Long id) {
        return service.getSaleItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SaleItem create(@RequestBody SaleItem item) {
        return service.saveSaleItem(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleItem> update(@PathVariable Long id, @RequestBody SaleItem updated) {
        return service.getSaleItemById(id)
                .map(existing -> {
                    existing.setProduct(updated.getProduct());
                    existing.setSale(updated.getSale());
                    existing.setQuantity(updated.getQuantity());
                    existing.setUnitPrice(updated.getUnitPrice());
                    return ResponseEntity.ok(service.saveSaleItem(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSaleItem(id);
    }
}
