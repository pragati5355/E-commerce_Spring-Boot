package com.mindbowser.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.mindbowser.entity.Role;
import com.mindbowser.entity.User;
import com.mindbowser.repository.RoleRepository;
import com.mindbowser.repository.UserRepository;

@Service
public class UserServicImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User registerNewUser(User user) {
		Role role = roleRepository.findById("User").get();
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRole(roles);

		user.setPassword(getEncodedPassword(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User registerNewAdmin(User user) {

		Role role = roleRepository.findById("Admin").get();
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRole(roles);

		user.setPassword(getEncodedPassword(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public void initRolesAndUser() {

		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin role in E-commerce Application");
		roleRepository.save(adminRole);

		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for newly created record in E-commerce Application");
		roleRepository.save(userRole);

		User adminUser = new User();
		adminUser.setFirstName("Admin");
		adminUser.setLastName("Admin");
		adminUser.setAddress("admin");
		adminUser.setEmail("admin@gmail.com");
		adminUser.setPassword(getEncodedPassword("admin@123"));
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userRepository.save(adminUser);

		User user = new User();
		user.setFirstName("Pragati");
		user.setLastName("Gawade");
		user.setAddress("Mahableshwar");
		user.setEmail("pragati@gmail.com");
		user.setPassword(getEncodedPassword("pragati@123"));
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(userRole);
		user.setRole(userRoles);
		userRepository.save(user);

	}

	@Override
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

}
