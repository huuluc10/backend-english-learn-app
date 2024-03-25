package com.huuluc.englearn.security;

import com.huuluc.englearn.exception.JwtTokenBlacklistException;
import com.huuluc.englearn.model.JwtTokenBlacklist;
import com.huuluc.englearn.repository.JwtTokenBlacklistRepository;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import java.util.Date;


@Component
@Slf4j
public class JwtUtils {
    @Value("${englearn.app.jwtSecret}")
    private String jwtSecret;

    @Value("${englearn.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    private JwtTokenBlacklistRepository repository;

    public JwtUtils(JwtTokenBlacklistRepository repository) {
        this.repository = repository;
    }

    public String generateJwtToken(Authentication authentication) {

        org.springframework.security.core.userdetails.User userPrincipal = (User) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }



    public String getUserNameFromJwtToken(String token) {
        String str = Jwts.parser().setSigningKey(jwtSecret)
                .parseClaimsJws(token).getBody().getSubject();
        return str;
    }

    // Get expiration date from token
    private Date getExpirationDateFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret)
                .parseClaimsJws(token).getBody().getExpiration();
    }

    // Check if token is expired
    private boolean isTokenExpired(String token) {
        return getExpirationDateFromJwtToken(token).before(new Date());
    }

    // Check if token is in blacklist
    private boolean isTokenInBlacklist(String token) throws JwtTokenBlacklistException {
        return repository.exists(token);
    }


    public int revokeToken(String jwt) throws JwtTokenBlacklistException {
        if (isTokenInBlacklist(jwt)) {
            return 1;
        }

        Date expiration = getExpirationDateFromJwtToken(jwt);

        JwtTokenBlacklist token = new JwtTokenBlacklist(jwt, expiration);
        if (repository.revokeToken(token) == 1) {
            return 1;
        }
        return 0;
    }

    public boolean validateJwtToken(String authToken) throws ExpiredJwtException, UnsupportedJwtException,
            MalformedJwtException, IllegalArgumentException, JwtTokenBlacklistException {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parse(authToken);

            // Check jwt in blacklist
            if (repository.exists(authToken)) {
                return false;
            }

            // Check if token is expired
            return !isTokenExpired(authToken);

        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
            throw new MalformedJwtException("Invalid JWT token");
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
            throw new ExpiredJwtException(null, null, "JWT token is expired");
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
            throw new UnsupportedJwtException("JWT token is unsupported");
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
            throw new IllegalArgumentException("JWT claims string is empty");
        }

    }
}
