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

import com.example.demo.Entity.Stock;
import com.example.demo.Service.StockService;





@RestController
@RequestMapping("/api/stocks")
public class StockController {
    @Autowired
    private StockService service;

    @GetMapping
    public List<Stock> getAll() {
        return service.getAllStocks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getById(@PathVariable Long id) {
        return service.getStockById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Stock create(@RequestBody Stock stock) {
        return service.saveStock(stock);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> update(@PathVariable Long id, @RequestBody Stock updated) {
        return service.getStockById(id)
                .map(existing -> {
                    existing.setProduct(updated.getProduct());
                    existing.setWarehouse(updated.getWarehouse());
                    existing.setQuantity(updated.getQuantity());
                    return ResponseEntity.ok(service.saveStock(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStock(id);
    }
}
