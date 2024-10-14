package com.example.demo.dao;

import com.example.demo.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductDAO {
    Product insertProduct(Product product);
    Product selectProduct(Long number);
    Product updateProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;

    Product saveProduct(Product product);
    Product getProduct(Long number);
    List<Product> findAllProduct();
    List<Product> findAllProductSort();
    Page<Product> findAllProductPageable(int pageNumber, int pageSize);
}
