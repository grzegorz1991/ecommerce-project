package pl.grzegorz.portfolio.ecommerce_project.api.controller.auth;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.grzegorz.portfolio.ecommerce_project.api.model.RegistrationBody;
import pl.grzegorz.portfolio.ecommerce_project.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @SuppressWarnings("FieldMayBeFinal")
    private UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody RegistrationBody registrationBody) {
        userService.registerUser(registrationBody);
    }

}
