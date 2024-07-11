package dev.nastiar.portal.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public String deleteProductById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "SUCCESS";
        } else {
            return "FAILED";
        }
    }

    public Optional<Product> editProductById(Long id, Product newProduct) {
        // Product product = productRepository.getReferenceById(id);

        // if (product != null) {
        // product.setName(newProduct.getName());
        // product.setColors(newProduct.getColors());
        // product.setPrice(newProduct.getPrice());
        // product.setPriceSale(newProduct.getPriceSale());
        // product.setStatus(newProduct.getStatus());
        // }
        // productRepository.save(product);

        return productRepository.findById(id).map(product -> {
            product.setName(newProduct.getName());
            product.setColors(newProduct.getColors());
            product.setPrice(newProduct.getPrice());
            product.setPriceSale(newProduct.getPriceSale());
            product.setStatus(newProduct.getStatus());
            return productRepository.save(product);
        });
    }

}
