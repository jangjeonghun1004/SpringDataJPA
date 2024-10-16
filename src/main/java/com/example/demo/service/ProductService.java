package com.example.demo.service;

import com.example.demo.dto.ProductChangeDTO;
import com.example.demo.dto.ProductChangeNameDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductResponseDTO;
import java.util.List;

public interface ProductService {
    ProductResponseDTO saveProduct(ProductDTO productDto);
    ProductResponseDTO getProduct(Long number);
    List<ProductResponseDTO> findAllProduct();
    List<ProductResponseDTO> findAllProductSort();
    List<ProductResponseDTO> findAllProductPageable(int pageNumber, int pageSize);
    List<ProductResponseDTO> findByProductName(String productName);
    ProductResponseDTO changeProductName(ProductChangeNameDTO productChangeNameDTO) throws Exception;
    ProductResponseDTO changeProduct(ProductChangeDTO productChangeDTO) throws Exception;
    void deleteProduct(Long number) throws Exception;
}