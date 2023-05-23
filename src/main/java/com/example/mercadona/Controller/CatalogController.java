package com.example.mercadona.Controller;

import com.example.mercadona.Product;
import com.example.mercadona.Repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CatalogController {

    private final ProductRepository productRepository;

    public CatalogController(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @GetMapping("/catalog")
    public String catalog(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);

        return "catalog";
    }

//        Filtre par catégories
//    @GetMapping("/catalog/{category}")
//    public String catalogByCategory(@PathVariable("category") String category, Model model) {
//        List<Product> products = productRepository.findByCategory(category);
//        model.addAttribute("products", products);
//        return "catalog";
//    }
}