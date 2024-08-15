package pl.grzegorz.portfolio.ecommerce_project.service;


import org.springframework.stereotype.Service;
import pl.grzegorz.portfolio.ecommerce_project.api.model.RegistrationBody;
import pl.grzegorz.portfolio.ecommerce_project.exception.UserAlreadyExistsException;
import pl.grzegorz.portfolio.ecommerce_project.model.LocalUser;
import pl.grzegorz.portfolio.ecommerce_project.model.dao.LocalUserDAO;

@Service

public class UserService {

    @SuppressWarnings("FieldMayBeFinal")
    private LocalUserDAO localUserDAO;
    private EncryptionService encryptionService;

    public UserService(LocalUserDAO localUserDAO, EncryptionService encryptionService) {
        this.localUserDAO = localUserDAO;
        this.encryptionService = encryptionService;
    }


    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {

        if (localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        ;


        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setUsername(registrationBody.getUsername());
        //TODO: ENCRYPT PASSWORD!
        user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        return localUserDAO.save(user);


    }

}
