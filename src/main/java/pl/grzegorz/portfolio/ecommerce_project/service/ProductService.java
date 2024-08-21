package pl.grzegorz.portfolio.ecommerce_project.service;


import org.springframework.stereotype.Service;
import pl.grzegorz.portfolio.ecommerce_project.model.Product;
import pl.grzegorz.portfolio.ecommerce_project.model.dao.WebProductDAO;

import java.util.List;

@Service
public class ProductService {

    private WebProductDAO webProductDAO;

    public ProductService(WebProductDAO webProductDAO) {
        this.webProductDAO = webProductDAO;
    }

    public List<Product> getProducts(){
        return webProductDAO.findAll();
    }
}
