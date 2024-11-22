package com.example.MinApple.controller;


import com.example.MinApple.entity.ColorProduct;
import com.example.MinApple.service.ColorProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/color-products")
public class ColorProductController {

    @Autowired
    private ColorProductService colorProductService;

    @GetMapping("/all")
    public List<ColorProduct> getAllColorProducts() {
        return colorProductService.getAllColorProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColorProduct> getColorProductById(@PathVariable Long id) {
        return colorProductService.getColorProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ColorProduct createColorProduct(@RequestBody ColorProduct colorProduct) {
        return colorProductService.createColorProduct(colorProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColorProduct> updateColorProduct(@PathVariable Long id, @RequestBody ColorProduct colorProductDetails) {
        return colorProductService.getColorProductById(id)
                .map(colorProduct -> ResponseEntity.ok(colorProductService.updateColorProduct(id, colorProductDetails)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColorProduct(@PathVariable Long id) {
        if (colorProductService.getColorProductById(id).isPresent()) {
            colorProductService.deleteColorProduct(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
