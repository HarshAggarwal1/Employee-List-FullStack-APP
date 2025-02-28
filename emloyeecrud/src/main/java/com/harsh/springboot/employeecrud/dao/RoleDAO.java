package com.harsh.springboot.employeecrud.dao;

import com.harsh.springboot.employeecrud.entity.Role;

public interface RoleDAO {

    public Role findRoleByName(String theRoleName);

}
