package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;
    public ProductService() {
// Note: no new Product(...) anywhere — it is abstract now.
        products.add(new DigitalProduct(
                nextId++, "Clean Code (E-book)", 29.99,
                "/downloads/clean-code.pdf", 4.2));
        products.add(new PhysicalProduct(
                nextId++, "27-inch Monitor", 249.99,
                5.4, "61cm x 41cm x 18cm"));
    }
    public List<Product> getAllProducts() {
        return products;
    }
    public List<String> getAllSummaries() {
        List<String> summaries = new ArrayList<>();
        for (Product p : products) {
// One line. No instanceof, no casts, no type names.
            summaries.add(p.getSummary());
        }
        return summaries;
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

}