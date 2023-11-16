package com.example.project_default_jsp.service;

import com.example.project_default_jsp.model.Login;
import com.example.project_default_jsp.model.User;

public interface IUserService {
    User checkLogin(Login login);
}
