package com.example.demo.dao;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class ProductDAOImpl implements ProductDAO {
    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product getProduct(Long number) {
        return this.productRepository.getReferenceById(number);
    }

    @Override
    public List<Product> findAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public List<Product> findAllProductSort() {
        return this.productRepository.findAll(Sort.by(Sort.Direction.DESC, "number"));
    }

    @Override
    public Page<Product> findAllProductPageable(int pageNumber, int pageSize) {
        return this.productRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }










    @Override
    public Product insertProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        //this.productRepository.saveAndFlush(product);

        return savedProduct;
    }

    @Override
    public Product selectProduct(Long number) {
        Product selectedProduct = productRepository.getReferenceById(number);

        return selectedProduct;
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updatedProduct;
        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            updatedProduct = productRepository.save(product);
        } else {
            throw new Exception();
        }

        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            productRepository.delete(product);
        } else {
            throw new Exception();
        }
    }





}