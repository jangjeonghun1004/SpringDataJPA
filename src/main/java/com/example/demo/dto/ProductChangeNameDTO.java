package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductChangeNameDTO {
    private Long number;
    private String name;

    public ProductChangeNameDTO() { }
    public ProductChangeNameDTO(Long number, String name) {
        this.number = number;
        this.name = name;
    }
}