package pl.grzegorz.portfolio.ecommerce_project.model.dao;

import org.springframework.data.repository.ListCrudRepository;
import pl.grzegorz.portfolio.ecommerce_project.api.model.VerificationToken;

public interface VerificationTokenDAO extends ListCrudRepository<VerificationToken, Long> {


}
