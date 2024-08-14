package pl.grzegorz.portfolio.ecommerce_project.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import pl.grzegorz.portfolio.ecommerce_project.model.LocalUser;

import java.util.Optional;

@Service
public interface LocalUserDAO extends CrudRepository<LocalUser, Long> {


    Optional<LocalUser> findByUsernameIgnoreCase(String username);

    Optional<LocalUser> findByEmailIgnoreCase(String email);
}
