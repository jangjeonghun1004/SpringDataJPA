package com.example.demo.controller;

import com.example.demo.dto.ChangeProductNameDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<ProductResponseDTO> getProduct(Long number) {
        ProductResponseDTO productResponseDto = productService.getProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductDTO productDto) {
        ProductResponseDTO productResponseDto = productService.saveProduct(productDto);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PutMapping()
    public ResponseEntity<ProductResponseDTO> changeProductName(
            @RequestBody ChangeProductNameDTO changeProductNameDto) throws Exception {
        ProductResponseDTO productResponseDto = productService.changeProductName(
                changeProductNameDto.getNumber(),
                changeProductNameDto.getName());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);

    }

    @DeleteMapping()
    public ResponseEntity<String> deleteProduct(Long number) throws Exception {
        productService.deleteProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

}