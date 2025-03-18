package com.example.demo.product.mapper;

import com.example.demo.product.dto.ProductDto;
import com.example.demo.product.entity.Product;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getDescription(),
                product.getPrice()
        );
    }

    public static Product mapToProduct(ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getCategory(),
                productDto.getDescription(),
                productDto.getPrice()
        );
    }
}
