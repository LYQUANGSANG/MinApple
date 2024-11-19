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
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id") // Ánh xạ cột `product_id` từ cơ sở dữ liệu
    private Long productId;

    @NotBlank(message = "Processor is mandatory")
    private String processor;

    @NotNull(message = "RAM size is mandatory")
    private Integer ram; // GB

    @NotNull(message = "Storage size is mandatory")
    private Integer storage; // GB

    private String graphicsCard;
    private String screenSize;
    private String battery;
    private String operatingSystem;
    private String weight;

//    @OneToOne(mappedBy = "product") // Liên kết với bảng Product
//    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Processor is mandatory") String getProcessor() {
        return processor;
    }

    public void setProcessor(@NotBlank(message = "Processor is mandatory") String processor) {
        this.processor = processor;
    }

    public @NotNull(message = "RAM size is mandatory") Integer getRam() {
        return ram;
    }

    public void setRam(@NotNull(message = "RAM size is mandatory") Integer ram) {
        this.ram = ram;
    }

    public @NotNull(message = "Storage size is mandatory") Integer getStorage() {
        return storage;
    }

    public void setStorage(@NotNull(message = "Storage size is mandatory") Integer storage) {
        this.storage = storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    //    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
}
