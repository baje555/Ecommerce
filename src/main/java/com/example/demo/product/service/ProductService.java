package com.example.demo.product.service;

import com.example.demo.product.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);
    ProductDto getProductById(Long productId);
    List<ProductDto> getAllProducts();
    ProductDto updateProduct(Long productId, ProductDto updatedProduct);

    void deleteProduct(Long productId);

}
