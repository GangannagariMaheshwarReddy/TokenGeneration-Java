package com.example.tokengeneration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class TokenController {

	@Autowired
	TokenService tokenservice;
	
	@GetMapping("/token")
	String generateToken(@RequestParam("username") String username, @RequestParam("role") String role) {
		
		String token = tokenservice.getToken(username, role);
		return "Congratulations " + username + " your token is " + token;
	}

}
