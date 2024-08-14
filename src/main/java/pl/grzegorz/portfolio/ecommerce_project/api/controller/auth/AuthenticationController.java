package pl.grzegorz.portfolio.ecommerce_project.api.controller.auth;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.grzegorz.portfolio.ecommerce_project.api.model.RegistrationBody;
import pl.grzegorz.portfolio.ecommerce_project.exception.UserAlreadyExistsException;
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
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody) {
        try {
            userService.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
