package pl.grzegorz.portfolio.ecommerce_project.api.controller.auth;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.grzegorz.portfolio.ecommerce_project.api.model.LoginBody;
import pl.grzegorz.portfolio.ecommerce_project.api.model.LoginResponse;
import pl.grzegorz.portfolio.ecommerce_project.api.model.RegistrationBody;
import pl.grzegorz.portfolio.ecommerce_project.exception.EmailFailureException;
import pl.grzegorz.portfolio.ecommerce_project.exception.UserAlreadyExistsException;
import pl.grzegorz.portfolio.ecommerce_project.exception.UserNotVerifiedException;
import pl.grzegorz.portfolio.ecommerce_project.model.LocalUser;
import pl.grzegorz.portfolio.ecommerce_project.service.EncryptionService;
import pl.grzegorz.portfolio.ecommerce_project.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {


    private UserService userService;

    private EncryptionService encryptionService;

    public AuthenticationController(UserService userService, EncryptionService encryptionService) {
        this.userService = userService;
        this.encryptionService = encryptionService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody) {
        try {
            userService.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }catch (EmailFailureException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@Valid @RequestBody LoginBody loginBody) {
        String jwt = null;
        try {
            jwt = userService.loginUser(loginBody);
        } catch (UserNotVerifiedException e) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setSuccess(false);
            String reason = "USER_NOT_VERIFIED";
            if (e.isNewEmailSent()){
                reason += " EMAIL_RESENT";
             }
            loginResponse.setFailureReason(reason);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(loginResponse);
        } catch (EmailFailureException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            LoginResponse response = new LoginResponse();
            response.setJwt(jwt);
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/me")
    public LocalUser getLoggedinUserProfile(@AuthenticationPrincipal LocalUser user) {
        return user;
    }
}
