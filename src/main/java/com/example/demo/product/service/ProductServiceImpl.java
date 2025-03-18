package com.example.demo.product.service;

import com.example.demo.product.dto.ProductDto;
import com.example.demo.product.entity.Product;
import com.example.demo.product.exception.ResourceNotFoundException;
import com.example.demo.product.mapper.ProductMapper;
import com.example.demo.product.productRepo.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product is not available"));
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto updatedProduct) {
        // Retrieve the existing product
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product does not exist"));

        // Update the product fields
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setCategory(updatedProduct.getCategory());

        // Save the updated product
        Product updatedProductObj = productRepository.save(product);
        return ProductMapper.mapToProductDto(updatedProductObj);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product does not exist"));
        productRepository.deleteById(productId);
    }
}