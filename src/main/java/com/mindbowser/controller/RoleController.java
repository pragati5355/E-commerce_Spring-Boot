package com.mindbowser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mindbowser.entity.Role;
import com.mindbowser.service.RoleServiceImpl;

@RestController
public class RoleController {

	@Autowired
	private RoleServiceImpl roleServiceImpl;

	@PostMapping({"/createNewRole"})
	public Role createNewRole(@RequestBody Role role) {
		return roleServiceImpl.createNewRole(role);
	}

}
