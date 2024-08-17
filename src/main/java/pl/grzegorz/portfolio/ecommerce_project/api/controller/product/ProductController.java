package pl.grzegorz.portfolio.ecommerce_project.api.controller.product;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.grzegorz.portfolio.ecommerce_project.model.Product;
import pl.grzegorz.portfolio.ecommerce_project.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();

    }

}
