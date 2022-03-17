package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> loginDetails();
    String newRegister(User user);
    String createNewPassword(String email, String password);
}
