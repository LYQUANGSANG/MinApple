package com.example.MinApple.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ColorProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product ID is mandatory")
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotBlank(message = "Color name is mandatory")
    private String colorName;

    @NotBlank(message = "Hex code is mandatory")
    private String hexCode;

    @NotNull(message = "Quantity is mandatory")
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "Product ID is mandatory") Product getProduct() {
        return product;
    }

    public void setProduct(@NotNull(message = "Product ID is mandatory") Product product) {
        this.product = product;
    }

    public @NotBlank(message = "Color name is mandatory") String getColorName() {
        return colorName;
    }

    public void setColorName(@NotBlank(message = "Color name is mandatory") String colorName) {
        this.colorName = colorName;
    }

    public @NotBlank(message = "Hex code is mandatory") String getHexCode() {
        return hexCode;
    }

    public void setHexCode(@NotBlank(message = "Hex code is mandatory") String hexCode) {
        this.hexCode = hexCode;
    }

    public @NotNull(message = "Quantity is mandatory") Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@NotNull(message = "Quantity is mandatory") Integer quantity) {
        this.quantity = quantity;
    }
}
