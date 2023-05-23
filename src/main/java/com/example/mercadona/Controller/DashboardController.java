package com.example.mercadona.Controller;

import com.example.mercadona.Product;
import com.example.mercadona.Repository.ProductRepository;
import com.example.mercadona.Repository.UserRepository;
import com.example.mercadona.Service.ProductService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class DashboardController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    public DashboardController(ProductService productService, ProductRepository productRepository, UserRepository userRepository) {

        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/dashboard")
    public String getProductList(Model model) {

        List<Product> products = productRepository.findAll();

        model.addAttribute("products", products);

        return "/dashboard";
    }

    @GetMapping("/dashboard/products/edit/{productId}")
    public String showEditProductForm(@PathVariable("productId") int productId, Model model) {
        Product product = productService.getProductById((long) productId);
        if (product == null) {

            return "redirect:/dashboard";
        }
        model.addAttribute("product", product);

        return "/editProduct";
    }

    @PostMapping("/dashboard/products/edit/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId, @RequestParam() String label,
                                    @RequestParam() String description,
                                    @RequestParam() double price,
                                    @RequestParam() String category,
                                    @RequestParam(required = false) boolean promotion,
                                    @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Optional<LocalDateTime> startDatePromo,
                                    @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Optional<LocalDateTime> endDatePromo,
                                    @RequestParam(required = false) Integer discountPercentage) {

        Product product = productService.getProductById(productId);
        if (product == null) {

            return "redirect:/dashboard";
        }

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
            product.setDiscountPercentage(0);
        }

        productService.updateProduct(product);

        return "redirect:/dashboard";
    }

    @PostMapping ("/dashboard/products/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);

        return "redirect:/dashboard";
    }
}
