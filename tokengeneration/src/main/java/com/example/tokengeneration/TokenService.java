package com.example.tokengeneration;


import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenService {
	
	SecretKey signingKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	String getToken(String username, String role) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(username);
		builder.claim("role", role);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date(System.currentTimeMillis() + 36000));
		builder.signWith(signingKey);
		String token = builder.compact();
		return token;
	}
}
