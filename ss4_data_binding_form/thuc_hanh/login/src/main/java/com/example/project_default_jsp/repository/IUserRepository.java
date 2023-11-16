package com.example.project_default_jsp.repository;

import com.example.project_default_jsp.model.Login;
import com.example.project_default_jsp.model.User;

public interface IUserRepository {
    User checkLogin(Login login);
}
