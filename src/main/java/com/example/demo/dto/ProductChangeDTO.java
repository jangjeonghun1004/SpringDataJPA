package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductChangeDTO {
    private Long number;
    private String name;
    private int price;
    private int stock;

    public ProductChangeDTO() {}
    public ProductChangeDTO(Long number, String name, int price, int stock) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}