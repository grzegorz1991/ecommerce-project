package pl.grzegorz.portfolio.ecommerce_project.service;


import org.springframework.stereotype.Service;
import pl.grzegorz.portfolio.ecommerce_project.api.model.RegistrationBody;
import pl.grzegorz.portfolio.ecommerce_project.model.LocalUser;
import pl.grzegorz.portfolio.ecommerce_project.model.dao.LocalUserDAO;

@Service

public class UserService {

    @SuppressWarnings("FieldMayBeFinal")
    private LocalUserDAO localUserDAO;

    public UserService(LocalUserDAO localUserDAO) {
        this.localUserDAO = localUserDAO;
    }

    @SuppressWarnings("UnusedReturnValue")
    public LocalUser registerUser(RegistrationBody registrationBody){
    LocalUser user = new LocalUser();
    user.setEmail(registrationBody.getEmail());
    user.setFirstName(registrationBody.getFirstName());
    user.setLastName(registrationBody.getLastName());
    user.setUsername(registrationBody.getUsername());
    //TODO: ENCRYPT PASSWORD!
    user.setPassword(registrationBody.getPassword());
    return localUserDAO.save(user);



}

}
