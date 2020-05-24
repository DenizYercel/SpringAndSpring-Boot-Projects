package com.deniz.dao;

import com.deniz.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
