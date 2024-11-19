package com.example.MinApple.service;

import com.example.MinApple.entity.ProductDetail;
import com.example.MinApple.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailService {

        @Autowired
        private ProductDetailRepository productDetailRepository;


        public Optional<ProductDetail> getProductDetailById(Long id) {
            return productDetailRepository.findById(id);
        }

        public ProductDetail createProductDetail(ProductDetail productDetail) {
            return productDetailRepository.save(productDetail);
        }

        public ProductDetail updateProductDetail(Long id, ProductDetail productDetailDetails) {
            ProductDetail productDetail = productDetailRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("ProductDetail not found"));
            productDetail.setProcessor(productDetailDetails.getProcessor());
            productDetail.setRam(productDetailDetails.getRam());
            productDetail.setStorage(productDetailDetails.getStorage());
            productDetail.setGraphicsCard(productDetailDetails.getGraphicsCard());
            productDetail.setScreenSize(productDetailDetails.getScreenSize());
            productDetail.setBattery(productDetailDetails.getBattery());
            productDetail.setOperatingSystem(productDetailDetails.getOperatingSystem());
            productDetail.setWeight(productDetailDetails.getWeight());
            return productDetailRepository.save(productDetail);
        }

        public void deleteProductDetail(Long id) {
            productDetailRepository.deleteById(id);
        }

    public List<ProductDetail> getProductDetailsByProductId(Long productId) {
        return productDetailRepository.findAllByProductId(productId);
    }
    }

