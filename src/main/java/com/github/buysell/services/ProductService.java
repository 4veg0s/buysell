package com.github.buysell.services;

import com.github.buysell.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product(++ID, "PlayStation 5", "Wet dream", 67000, "Saint-P", "4veg0s"));
        products.add(new Product(++ID, "iPhone 15", "Girls dream", 100000, "Moscow", "s0gev4"));
        products.add(new Product(++ID, "HUAWEI D15 notebook", "Does it's job well", 40000, "Saint-P", "4veg0s"));
    }

    public List<Product> listProducts() { return products; }

    public  void saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) return product;
        }
        return null;    // FIXME: add optional?
    }
}
