package se.iths.grocerylistgenerator.jwt;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    @Value("${security.jwt.secret}")
    private String secretKey;

    public Algorithm getJwtAlgorithm() {
        return Algorithm.HMAC256(secretKey);
    }
}
