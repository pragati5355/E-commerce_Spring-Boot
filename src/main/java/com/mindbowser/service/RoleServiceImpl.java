package com.mindbowser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindbowser.entity.Role;
import com.mindbowser.repository.RoleRepository;

@Service
public class RoleServiceImpl {

	@Autowired
	private RoleRepository roleRepository;

	public Role createNewRole(Role role) {
		return roleRepository.save(role);

	}

}
