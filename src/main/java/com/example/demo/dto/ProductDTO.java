package com.example.demo.dto;

import lombok.*;

@Data
@ToString
@Builder
@Getter
@Setter
public class ProductDTO {
    private String name;
    private int price;
    private int stock;

    public ProductDTO(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}