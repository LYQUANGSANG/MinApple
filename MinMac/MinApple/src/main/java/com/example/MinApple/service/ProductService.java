package com.example.MinApple.service;

import com.example.MinApple.entity.Product;
import com.example.MinApple.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDetails.getName());
        product.setMemo(productDetails.getMemo());
        product.setCategoryId(productDetails.getCategoryId());
        product.setSubCategoryId(productDetails.getSubCategoryId());
        product.setStatus(productDetails.getStatus());
        product.setPrice(productDetails.getPrice());
        product.setIsNew(productDetails.getIsNew());
        product.setViews(productDetails.getViews());
        product.setQuantitySold(productDetails.getQuantitySold());
        product.setImage(productDetails.getImage());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


    
}
