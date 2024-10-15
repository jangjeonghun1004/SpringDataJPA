package com.example.demo.service;

import com.example.demo.dao.ProductDAO;
import com.example.demo.dto.ProductChangeDTO;
import com.example.demo.dto.ProductChangeNameDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.entity.Product;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }


    @Override
    public ProductResponseDTO saveProduct(ProductDTO productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        Product savedProduct = this.productDAO.saveProduct(product);

        ProductResponseDTO productResponseDto = new ProductResponseDTO();
        productResponseDto.setNumber(savedProduct.getNumber());
        productResponseDto.setName(savedProduct.getName());
        productResponseDto.setPrice(savedProduct.getPrice());
        productResponseDto.setStock(savedProduct.getStock());

        return productResponseDto;
    }

    @Override
    public ProductResponseDTO getProduct(Long number) {
        Product product = this.productDAO.getProduct(number);

        return ProductResponseDTO.builder()
                .number(product.getNumber())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }

    @Override
    public List<ProductResponseDTO> findAllProduct() {
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<ProductResponseDTO>();
        List<Product> products = this.productDAO.findAllProduct();

        products.forEach((product) -> {
            productResponseDTOs.add(new ProductResponseDTO(
                    product.getNumber(),
                    product.getName(),
                    product.getPrice(),
                    product.getStock())
            );
        });

        return productResponseDTOs;
    }

    @Override
    public List<ProductResponseDTO> findAllProductSort() {
        List<Product> products = this.productDAO.findAllProductSort();

        List<ProductResponseDTO> productResponseDTOs = new ArrayList<ProductResponseDTO>();
        products.forEach((product) -> {
            productResponseDTOs.add(new ProductResponseDTO(
                    product.getNumber(),
                    product.getName(),
                    product.getPrice(),
                    product.getStock()
            ));
        });

        return productResponseDTOs;
    }

    @Override
    public List<ProductResponseDTO> findAllProductPageable(int pageNumber, int pageSize) {
        Page<Product> products = this.productDAO.findAllProductPageable(pageNumber, pageSize);

        List<ProductResponseDTO> productResponseDTOs = new ArrayList<ProductResponseDTO>();
        products.forEach((product) -> {
            productResponseDTOs.add(new ProductResponseDTO(
                    product.getNumber(),
                    product.getName(),
                    product.getPrice(),
                    product.getStock()
            ));
        });

        log.info("Total Pages = {}", products.getTotalPages());
        log.info("Total elements = {}", products.getTotalElements());
        log.info("Current page contents = {}", products.getContent());

        return productResponseDTOs;
    }

    @Override
    public ProductResponseDTO changeProductName(ProductChangeNameDTO productChangeNameDTO) throws Exception {
        Product changedProduct = productDAO.changeProductName(productChangeNameDTO.getNumber(), productChangeNameDTO.getName());

        ProductResponseDTO productResponseDto = new ProductResponseDTO();
        productResponseDto.setNumber(changedProduct.getNumber());
        productResponseDto.setName(changedProduct.getName());
        productResponseDto.setPrice(changedProduct.getPrice());
        productResponseDto.setStock(changedProduct.getStock());

        return productResponseDto;
    }

    @Override
    public ProductResponseDTO changeProduct(ProductChangeDTO productChangeDTO) throws Exception {
        Product product = this.productDAO.changeProduct(
                productChangeDTO.getNumber(),
                productChangeDTO.getName(),
                productChangeDTO.getPrice(),
                productChangeDTO.getStock()
        );

        return ProductResponseDTO.builder()
                .number(product.getNumber())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        this.productDAO.deleteProduct(number);
    }
}