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

import com.example.demo.Entity.StockMovement;
import com.example.demo.Service.StockMovementService;





@RestController
@RequestMapping("/api/stock-movements")
public class StockMovementController {
    @Autowired
    private StockMovementService service;

    @GetMapping
    public List<StockMovement> getAll() {
        return service.getAllStockMovements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockMovement> getById(@PathVariable Long id) {
        return service.getStockMovementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StockMovement create(@RequestBody StockMovement movement) {
        return service.saveStockMovement(movement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockMovement> update(@PathVariable Long id, @RequestBody StockMovement updated) {
        return service.getStockMovementById(id)
                .map(existing -> {
                    existing.setProduct(updated.getProduct());
                    existing.setWarehouse(updated.getWarehouse());
                    existing.setUser(updated.getUser());
                    existing.setQuantity(updated.getQuantity());
                    existing.setType(updated.getType());
                    existing.setDate(updated.getDate());
                    existing.setValue(updated.getValue());
                    return ResponseEntity.ok(service.saveStockMovement(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStockMovement(id);
    }
}
