package com.example.mercadona.Repository;

import com.example.mercadona.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    En cours, pour le filtre par catégories
    List<Product> findByCategory(String category);

}