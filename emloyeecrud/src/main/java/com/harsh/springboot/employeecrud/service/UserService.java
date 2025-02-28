package com.harsh.springboot.employeecrud.service;

import com.harsh.springboot.employeecrud.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

}

