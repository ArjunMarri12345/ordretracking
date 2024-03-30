package springboot.orderstrackingsystem.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.orderstrackingsystem.model.Product;
import springboot.orderstrackingsystem.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:8080/products", methods = { RequestMethod.POST })
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PostMapping("/saveAll")
    public List<Product> saveAllProducts(@RequestBody List<Product> products) {
        return productService.saveAllProducts(products);
    }

    @GetMapping("/productNames")
    public List<Product> getAllProductsByProductName(@RequestParam String productName) {
        return productService.getByProductName(productName);
    }
@GetMapping("/{pageNumber}/{pageSize}")
    public List<Product> getProductsByPagination(@PathVariable int pageNumber, @PathVariable int pageSize)
    {
        return productService.getAllByPagination(pageNumber, pageSize);
    }

}
