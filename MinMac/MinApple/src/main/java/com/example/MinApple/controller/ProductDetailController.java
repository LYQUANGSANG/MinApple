package com.example.MinApple.controller;

import com.example.MinApple.entity.ProductDetail;
import com.example.MinApple.service.ProductDetailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product-details")
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetail> getProductDetailById(@PathVariable Long id) {
        return productDetailService.getProductDetailById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ProductDetail createProductDetail(@Valid @RequestBody ProductDetail productDetail) {
        return productDetailService.createProductDetail(productDetail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDetail> updateProductDetail(
            @PathVariable Long id, @Valid @RequestBody ProductDetail productDetailDetails) {
        return productDetailService.getProductDetailById(id)
                .map(productDetail -> ResponseEntity.ok(productDetailService.updateProductDetail(id, productDetailDetails)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductDetail(@PathVariable Long id) {
        if (productDetailService.getProductDetailById(id).isPresent()) {
            productDetailService.deleteProductDetail(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
