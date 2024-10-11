package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

// 예제 6.28
@Getter
@Setter
public class ChangeProductNameDTO {
    private Long number;
    private String name;

    public ChangeProductNameDTO(Long number, String name) {
        this.number = number;
        this.name = name;
    }

    public ChangeProductNameDTO() {
    }
}