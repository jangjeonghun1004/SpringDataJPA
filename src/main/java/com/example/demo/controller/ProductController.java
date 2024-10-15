package com.example.demo.controller;

import com.example.demo.dto.ProductChangeNameDTO;
import com.example.demo.dto.ProductChangeDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/createProduct")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody(required = true) ProductDTO productDto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.saveProduct(productDto));
    }

    @GetMapping("/getProduct")
    public ResponseEntity<ProductResponseDTO> getProduct(@RequestParam(required = true) Long number) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.getProduct(number));
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
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "2") int pageSize
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findAllProductPageable(pageNumber, pageSize));
    }

    @PatchMapping("/changeProductName")
    public ResponseEntity<ProductResponseDTO> changeProductName(
            @RequestBody(required = true) ProductChangeNameDTO productChangeNameDTO
    ) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.changeProductName(productChangeNameDTO));
    }

    @PutMapping("/changeProduct")
    public ResponseEntity<ProductResponseDTO> changeProduct(
            @RequestBody(required = true) ProductChangeDTO productChangeDTO
    ) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.changeProduct(productChangeDTO));
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity<String> deleteProduct(Long number) throws Exception {
        this.productService.deleteProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

}