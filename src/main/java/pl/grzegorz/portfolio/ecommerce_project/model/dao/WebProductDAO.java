package pl.grzegorz.portfolio.ecommerce_project.model.dao;

import org.springframework.data.repository.ListCrudRepository;
import pl.grzegorz.portfolio.ecommerce_project.model.Product;

public interface WebProductDAO extends ListCrudRepository<Product, Long> {


}
