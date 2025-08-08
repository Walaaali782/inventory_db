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

import com.example.demo.Entity.Sale;
import com.example.demo.Service.SaleService;





@RestController
@RequestMapping("/api/sales")
public class SaleController {
    @Autowired
    private SaleService service;

    @GetMapping
    public List<Sale> getAll() {
        return service.getAllSales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getById(@PathVariable Long id) {
        return service.getSaleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sale create(@RequestBody Sale sale) {
        return service.saveSale(sale);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sale> update(@PathVariable Long id, @RequestBody Sale updated) {
        return service.getSaleById(id)
                .map(existing -> {
                    existing.setCustomer(updated.getCustomer());
                    existing.setDate(updated.getDate());
                    existing.setTotalAmount(updated.getTotalAmount());
                    existing.setUser(updated.getUser());
                    return ResponseEntity.ok(service.saveSale(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSale(id);
    }
}
