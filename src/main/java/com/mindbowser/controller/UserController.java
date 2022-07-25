package com.mindbowser.controller;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mindbowser.entity.JwtRequest;
import com.mindbowser.entity.JwtResponse;
import com.mindbowser.entity.User;
import com.mindbowser.service.JwtService;
import com.mindbowser.service.UserServicImpl;

@RestController
public class UserController {

	@Autowired
	private UserServicImpl userServicImpl;

	@Autowired
	private JwtService jwtService;

	@PostConstruct
	public void initRolesAndUsers() {
		userServicImpl.initRolesAndUser();
	}

	@PostMapping({"/signup/admin"})
	public User registerNewAdmin(@RequestBody User user) {
		return userServicImpl.registerNewAdmin(user);
	}

	@PostMapping({"/signup"})
	public User registerNewUser(@RequestBody User user) {
		return userServicImpl.registerNewUser(user);
	}

	@PostMapping({"/signin"})
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		return jwtService.createJwtToken(jwtRequest);
	}

	@GetMapping({"/forAdmin"})
	public String forAdmin() {
		return "This URL is only accessible for Admin";
	}

	@GetMapping({"/forUser"})
	public String forUser() {
		return "This URL is only accessible for User";
	}

}
