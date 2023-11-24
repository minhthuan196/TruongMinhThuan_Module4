package com.example.register_form.service;

import com.example.register_form.model.User;
import com.example.register_form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
