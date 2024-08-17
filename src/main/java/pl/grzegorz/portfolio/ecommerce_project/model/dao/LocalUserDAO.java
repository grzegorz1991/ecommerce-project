package pl.grzegorz.portfolio.ecommerce_project.model.dao;

import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;
import pl.grzegorz.portfolio.ecommerce_project.model.LocalUser;

import java.util.Optional;

@Service
public interface LocalUserDAO extends ListCrudRepository<LocalUser, Long> {


    Optional<LocalUser> findByUsernameIgnoreCase(String username);

    Optional<LocalUser> findByEmailIgnoreCase(String email);
}
