package com.example.demo.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prod_name",nullable = false)
    private String name;
    @Column(name = "category")
private String category;
    @Column(name = "description",nullable = true)
    private String description;
    @Column(name = "price",nullable = false)
    private double price;
}
