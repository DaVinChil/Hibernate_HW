package com.example.hibernate_hw.controller;

import com.example.hibernate_hw.repository.ProductFetchRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProductFetchController {

    private ProductFetchRepository repo;

    public ProductFetchController(ProductFetchRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/products/fetch")
    public List<String> getProduct(@RequestParam("name") String name) {
        return repo.getProductName(name);
    }
}