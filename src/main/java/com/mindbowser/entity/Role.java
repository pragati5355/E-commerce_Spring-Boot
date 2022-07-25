package com.mindbowser.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	private String roleName;
	private String roleDescription;

	public Role() {
		super();
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}

	public Role(String roleName, String roleDescription) {
		super();
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

}
