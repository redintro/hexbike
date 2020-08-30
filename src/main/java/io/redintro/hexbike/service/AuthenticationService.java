package io.redintro.hexbike.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

public class AuthenticationService {
    private static final long EXPIRATION_TIME = 86400000; // 1 day in ms
    private static final String SIGNING_KEY = "SecretKey";
    private static final String PREFIX = "Bearer";
    private static final String HEADER_NAME = "Authorization";

    public static void addToken(HttpServletResponse res, String username) {
        res.addHeader(HEADER_NAME, PREFIX + " " + getToken(username));
    }

    public static Authentication getAuthentication(HttpServletRequest req) {
        Optional<String> token = Optional.ofNullable(req.getHeader(HEADER_NAME));

        Optional<String> user = token.map(t -> Jwts.parser()
                .setSigningKey(SIGNING_KEY)
                .parseClaimsJws(t.replace(PREFIX, ""))
                .getBody()
                .getSubject());

        return user.map(u -> new UsernamePasswordAuthenticationToken(u, null,
                Collections.emptyList())).orElse(null);
    }

    public static String getToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SIGNING_KEY).compact();
    }
}
