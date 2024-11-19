package com.example.MinApple.service;

import com.example.MinApple.entity.ColorProduct;
import com.example.MinApple.repository.ColorProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorProductService {

    @Autowired
    private ColorProductRepository colorProductRepository;

    public List<ColorProduct> getAllColorProducts() {
        return colorProductRepository.findAll();
    }

    public Optional<ColorProduct> getColorProductById(Long id) {
        return colorProductRepository.findById(id);
    }

    public ColorProduct createColorProduct(ColorProduct colorProduct) {
        return colorProductRepository.save(colorProduct);
    }

    public ColorProduct updateColorProduct(Long id, ColorProduct colorProductDetails) {
        ColorProduct colorProduct = colorProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ColorProduct not found"));
        colorProduct.setProduct(colorProductDetails.getProduct());
        colorProduct.setColorName(colorProductDetails.getColorName());
        colorProduct.setHexCode(colorProductDetails.getHexCode());
        colorProduct.setQuantity(colorProductDetails.getQuantity());
        return colorProductRepository.save(colorProduct);
    }

    public void deleteColorProduct(Long id) {
        colorProductRepository.deleteById(id);
    }
}
