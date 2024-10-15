package com.example.demo.dao;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Product changeProductName(Long number, String name) throws Exception {
        Optional<Product> selectedProduct = this.productRepository.findById(number);

        Product changedProduct;
        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            changedProduct = this.productRepository.save(product);
        } else {
            throw new Exception();
        }

        return changedProduct;
    }

    @Override
    public Product changeProduct(Long number, String name, int price, int stock) throws Exception {
        Optional<Product> selectedProduct = this.productRepository.findById(number);

        Product changedProduct;
        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            product.setName(name);
            product.setPrice(price);
            product.setStock(stock);

            changedProduct = this.productRepository.save(product);
        } else {
            throw new Exception();
        }

        return changedProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = this.productRepository.findById(number);

        if (selectedProduct.isPresent()) {
            productRepository.delete(selectedProduct.get());
        } else {
            throw new Exception();
        }
    }

}