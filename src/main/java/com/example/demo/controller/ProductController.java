package com.example.demo.controller;

import com.example.demo.dto.ChangeProductNameDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody(required = true) ProductDTO productDto) {
        ProductResponseDTO productResponseDto = productService.saveProduct(productDto);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @GetMapping()
    public ResponseEntity<ProductResponseDTO> getProduct(@RequestParam(required = true) Long number) {
        ProductResponseDTO productResponseDto = this.productService.getProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @GetMapping("/findAllProduct")
    public ResponseEntity<List<ProductResponseDTO>> findAllProduct() {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findAllProduct());
    }

    @GetMapping("/findAllProductSort")
    public ResponseEntity<List<ProductResponseDTO>> findAllProductSort() {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findAllProductSort());
    }

    @GetMapping("/findAllProductPageable")
    public ResponseEntity<List<ProductResponseDTO>> findAllProductPageable(
            @RequestParam(required = true) int pageNumber,
            @RequestParam(required = true) int pageSize
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findAllProductPageable(pageNumber, pageSize));
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