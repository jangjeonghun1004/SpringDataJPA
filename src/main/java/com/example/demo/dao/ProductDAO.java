package com.example.demo.dao;

import com.example.demo.entity.Product;
import org.springframework.data.domain.Page;
import java.util.List;

public interface ProductDAO {
    Product saveProduct(Product product);
    Product getProduct(Long number);
    List<Product> findAllProduct();
    List<Product> findAllProductSort();
    Page<Product> findAllProductPageable(int pageNumber, int pageSize);
    List<Product> findByProductName(String productName);
    Product changeProductName(Long number, String name) throws Exception;
    Product changeProduct(Long number, String name, int price, int stock) throws Exception;
    void deleteProduct(Long number) throws Exception;
}
