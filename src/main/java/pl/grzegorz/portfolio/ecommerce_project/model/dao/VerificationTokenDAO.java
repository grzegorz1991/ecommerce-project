package pl.grzegorz.portfolio.ecommerce_project.model.dao;

import org.springframework.data.repository.ListCrudRepository;
import pl.grzegorz.portfolio.ecommerce_project.api.model.VerificationToken;
import pl.grzegorz.portfolio.ecommerce_project.model.LocalUser;

import java.util.Optional;

public interface VerificationTokenDAO extends ListCrudRepository<VerificationToken, Long> {


    Optional<VerificationToken> findByToken(String token);

    void deleteByUser(LocalUser user);

}
