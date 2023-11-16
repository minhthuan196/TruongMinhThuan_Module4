package com.example.project_default_jsp.service;

import com.example.project_default_jsp.model.Login;
import com.example.project_default_jsp.model.User;
import com.example.project_default_jsp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User checkLogin(Login login) {
        return userRepository.checkLogin(login);
    }
}
