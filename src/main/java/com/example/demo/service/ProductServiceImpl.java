package com.example.demo.service;

import com.example.demo.dao.ProductDAO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.entity.Product;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductResponseDTO getProduct(Long number) {
        Product product = productDAO.selectProduct(number);

        ProductResponseDTO productResponseDto = new ProductResponseDTO();
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
    }

    @Override
    public ProductResponseDTO saveProduct(ProductDTO productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productDAO.insertProduct(product);

        ProductResponseDTO productResponseDto = new ProductResponseDTO();
        productResponseDto.setNumber(savedProduct.getNumber());
        productResponseDto.setName(savedProduct.getName());
        productResponseDto.setPrice(savedProduct.getPrice());
        productResponseDto.setStock(savedProduct.getStock());

        return productResponseDto;
    }

    @Override
    public ProductResponseDTO changeProductName(Long number, String name) throws Exception {
        Product changedProduct = productDAO.updateProductName(number, name);

        ProductResponseDTO productResponseDto = new ProductResponseDTO();
        productResponseDto.setNumber(changedProduct.getNumber());
        productResponseDto.setName(changedProduct.getName());
        productResponseDto.setPrice(changedProduct.getPrice());
        productResponseDto.setStock(changedProduct.getStock());

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }
}