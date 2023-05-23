package com.example.mercadona.Controller;

import com.example.mercadona.Product;
import com.example.mercadona.Repository.ProductRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @GetMapping("/product/create")
    public String showCreateProductForm(Model model) {
        model.addAttribute("product", new Product());

        return "createProduct";
    }

    @PostMapping("/product/create")
    public String createProduct(@RequestParam() String label,
                                @RequestParam() String description,
                                @RequestParam() double price,
                                @RequestParam() String category,
                                @RequestParam(required = false) boolean promotion,
                                @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Optional<LocalDateTime> startDatePromo,
                                @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Optional<LocalDateTime> endDatePromo,
                                @RequestParam(required = false) Integer discountPercentage) {


        Product product = new Product();
        product.setLabel(label);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategory(category);

        if(promotion) {
            product.setPromotion(true);

            if(startDatePromo.isPresent()) {
                LocalDateTime startDate = startDatePromo.get();
                Timestamp timestampStartDatePromo = Timestamp.valueOf(startDate);
                product.setStartDatePromo(timestampStartDatePromo);
            }

            if(endDatePromo.isPresent()) {
                LocalDateTime endDate = endDatePromo.get();
                Timestamp timestampEndDatePromo = Timestamp.valueOf(endDate);
                product.setEndDatePromo(timestampEndDatePromo);
            }

            product.setDiscountPercentage(discountPercentage);
        }else{
            product.setPromotion(false);
            product.setStartDatePromo(null);
            product.setEndDatePromo(null);
            product.setDiscountPercentage(discountPercentage);
        }

        productRepository.save(product);

        return "redirect:/dashboard";
    }

}
