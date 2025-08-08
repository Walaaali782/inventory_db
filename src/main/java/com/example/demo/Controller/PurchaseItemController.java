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

import com.example.demo.Entity.PurchaseItem;
import com.example.demo.Service.PurchaseItemService;





@RestController
@RequestMapping("/api/purchase-items")
public class PurchaseItemController {
    @Autowired
    private PurchaseItemService service;

    @GetMapping
    public List<PurchaseItem> getAll() {
        return service.getAllPurchaseItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseItem> getById(@PathVariable Long id) {
        return service.getPurchaseItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PurchaseItem create(@RequestBody PurchaseItem item) {
        return service.savePurchaseItem(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseItem> update(@PathVariable Long id, @RequestBody PurchaseItem updated) {
        return service.getPurchaseItemById(id)
                .map(existing -> {
                    existing.setProduct(updated.getProduct());
                    existing.setPurchase(updated.getPurchase());
                    existing.setQuantity(updated.getQuantity());
                    existing.setUnitPrice(updated.getUnitPrice());
                    return ResponseEntity.ok(service.savePurchaseItem(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deletePurchaseItem(id);
    }
}
