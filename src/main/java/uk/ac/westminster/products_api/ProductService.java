package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;


    // week 4 : activity 3
    public ProductService() {
        products.add(new DigitalProduct(
                nextId++, "Clean Code (E-book)", 29.99,
                "/downloads/clean-code.pdf", 4.2));
        products.add(new PhysicalProduct(nextId++, "27-inch Monitor", 249.99,
                5.4, "61cm x 41cm x 18cm"));
    }

    // ---- task 4 : return the whole catalogue ----
    public List<Product> getAllProducts() {
        return products;
    }

    // ---- task 8 : find one, or nothing ----
    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    // ---- task 4 : create, assigning the next id ----
    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    // ---- task 12 : delete by id ----
    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    // ---- task 16 : filter by name ----
    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }
}