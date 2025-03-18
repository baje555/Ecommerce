package com.example.demo.product.Controller;

import com.example.demo.product.dto.ProductDto;
import com.example.demo.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductDto saveProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
    }

    // This method retrieves all products
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        logger.info("Received request to get all products");
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // This method retrieves a product by its ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long productId) {
        logger.info("Received request to get product with ID: {}", productId);
        ProductDto productDto = productService.getProductById(productId);
        return ResponseEntity.ok(productDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable("id") Long productId,
            @RequestBody ProductDto updatedProduct) {
        logger.info("Received request to update product with ID: {}", productId);
        ProductDto productDto = productService.updateProduct(productId, updatedProduct);
        return ResponseEntity.ok(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId) {
        logger.info("Received request to delete product with ID: {}", productId);
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}