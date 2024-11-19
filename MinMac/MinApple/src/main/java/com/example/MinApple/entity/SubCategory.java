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
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Subcategory name is mandatory")
    private String name;

    private String description;

    @NotNull(message = "Category ID is mandatory")
    @Column(name = "category_id")
    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Subcategory name is mandatory") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Subcategory name is mandatory") String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public @NotNull(message = "Category ID is mandatory") Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@NotNull(message = "Category ID is mandatory") Long categoryId) {
        this.categoryId = categoryId;
    }
}
