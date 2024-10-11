package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductResponseDTO;

public interface ProductService {

    ProductResponseDTO getProduct(Long number);

    ProductResponseDTO saveProduct(ProductDTO productDto);

    ProductResponseDTO changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}