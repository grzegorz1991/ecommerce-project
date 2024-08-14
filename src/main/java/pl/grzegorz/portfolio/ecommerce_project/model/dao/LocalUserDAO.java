package pl.grzegorz.portfolio.ecommerce_project.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import pl.grzegorz.portfolio.ecommerce_project.model.LocalUser;

@Service
public interface LocalUserDAO extends CrudRepository<LocalUser, Long> {

}
