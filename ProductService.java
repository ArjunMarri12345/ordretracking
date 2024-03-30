package springboot.orderstrackingsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import springboot.orderstrackingsystem.model.Product;
import springboot.orderstrackingsystem.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveAllProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product>getAllByPagination(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return productRepository.findAll(pageRequest).getContent();
    }

    public List<Product> getByProductName(String productName) {
        List<Product> products = productRepository.findAll();
        List<Product> products2 = new ArrayList<>();
        if (products != null) {
            for (Product product : products) {
                if (product.getProductName().contains(productName)) {
                    products2.add(product);
                }
            }
        }
        return products2;
    }

}
