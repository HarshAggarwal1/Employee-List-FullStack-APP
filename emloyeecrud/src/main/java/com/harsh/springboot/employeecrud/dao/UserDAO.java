package com.harsh.springboot.employeecrud.dao;

import com.harsh.springboot.employeecrud.entity.User;

public interface UserDAO {

    public User findByUserName(String userName);

}
