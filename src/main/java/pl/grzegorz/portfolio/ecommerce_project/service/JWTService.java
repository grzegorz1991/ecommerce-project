package pl.grzegorz.portfolio.ecommerce_project.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.grzegorz.portfolio.ecommerce_project.model.LocalUser;

import java.util.Date;

@Service
//Jason Web Token
public class JWTService {

    @Value("${jwt.algorithm.key}")
    private String algorythmkey;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiryInSeconds}")
    private int expiryInSeconds;

    private Algorithm algorithm;
    private static final String USERNAME_KEY = "USERNAME";

    @PostConstruct
    public void postConstruct(){
        algorithm = Algorithm.HMAC256(algorythmkey);
    }


    public String generateJWT(LocalUser user){

        return JWT.create().withClaim(USERNAME_KEY, user.getUsername()).withExpiresAt(new Date(System.currentTimeMillis()+ (1000 * expiryInSeconds)))
                .withIssuer(issuer).sign(algorithm);
    }




}
