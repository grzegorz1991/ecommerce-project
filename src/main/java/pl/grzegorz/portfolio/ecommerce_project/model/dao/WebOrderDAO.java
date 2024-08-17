package pl.grzegorz.portfolio.ecommerce_project.model.dao;

import org.springframework.data.repository.ListCrudRepository;
import pl.grzegorz.portfolio.ecommerce_project.model.LocalUser;
import pl.grzegorz.portfolio.ecommerce_project.model.WebOrder;

import java.util.List;

public interface WebOrderDAO extends ListCrudRepository<WebOrder, Long> {

    List<WebOrder> findByUser(LocalUser user);
}
