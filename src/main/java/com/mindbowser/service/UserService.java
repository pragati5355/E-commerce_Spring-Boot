package com.mindbowser.service;

import com.mindbowser.entity.User;

public interface UserService {

	public void initRolesAndUser();

	public String getEncodedPassword(String password);

	public User registerNewAdmin(User user);

	public User registerNewUser(User user);

}
