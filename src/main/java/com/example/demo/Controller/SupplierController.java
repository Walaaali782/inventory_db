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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Supplier;
import com.example.demo.Service.SupplierService;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> getAll() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getById(@PathVariable Long id) {
        return supplierService.getSupplierById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Supplier create(@RequestBody Supplier supplier) {
        return supplierService.saveSupplier(supplier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
    }

    @GetMapping("/search")
    public List<Supplier> search(@RequestParam String name) {
        return supplierService.findByName(name);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Supplier> update(@PathVariable Long id, @RequestBody Supplier updated) {
        return supplierService.getSupplierById(id)
            .map(existing -> {
                existing.setName(updated.getName());
                existing.setPhone(updated.getPhone());
                existing.setEmail(updated.getEmail());
                existing.setCompanyName(updated.getCompanyName());
                existing.setAddress(updated.getAddress());
                return ResponseEntity.ok(supplierService.saveSupplier(existing));
            })
            .orElse(ResponseEntity.notFound().build());
    }

}
