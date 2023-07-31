package com.example.hibernate_hw.repository;

import jakarta.persistence.EntityManager;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductFetchRepository {
    private EntityManager entityManager;

    public ProductFetchRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private final String fetchProductSql = read("fetch_product.sql");

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name){
        return entityManager.createQuery(fetchProductSql).setParameter("customer_name", name).getResultList();
    }
}
