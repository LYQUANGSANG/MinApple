package com.example.MinApple.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String memo;

    @NotNull(message = "Category ID is mandatory")
    private Long categoryId;

    private Long subCategoryId;

    @NotBlank(message = "Status is mandatory")
    private String status;

    @NotNull(message = "Price is mandatory")
    @PositiveOrZero(message = "Price must be zero or positive")
    private BigDecimal price;

    private Boolean isNew;

    @PositiveOrZero(message = "Views must be zero or positive")
    private Integer views;

    @PositiveOrZero(message = "Quantity sold must be zero or positive")
    private Integer quantitySold;

    private String image;

//    @OneToOne(mappedBy = "product_detail")
//    private ProductDetail productDetail;

//    public ProductDetail getProductDetail() {
//        return productDetail;
//    }
//
//    public void setProductDetail(ProductDetail productDetail) {
//        this.productDetail = productDetail;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Name is mandatory") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is mandatory") String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public @NotNull(message = "Category ID is mandatory") Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@NotNull(message = "Category ID is mandatory") Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public @NotBlank(message = "Status is mandatory") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "Status is mandatory") String status) {
        this.status = status;
    }

    public @NotNull(message = "Price is mandatory") @PositiveOrZero(message = "Price must be zero or positive") BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "Price is mandatory") @PositiveOrZero(message = "Price must be zero or positive") BigDecimal price) {
        this.price = price;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public @PositiveOrZero(message = "Quantity sold must be zero or positive") Integer getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(@PositiveOrZero(message = "Quantity sold must be zero or positive") Integer quantitySold) {
        this.quantitySold = quantitySold;
    }

    public @PositiveOrZero(message = "Views must be zero or positive") Integer getViews() {
        return views;
    }

    public void setViews(@PositiveOrZero(message = "Views must be zero or positive") Integer views) {
        this.views = views;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
