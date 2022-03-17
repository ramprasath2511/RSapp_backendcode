package com.example.serviceImpl;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> loginDetails() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public String newRegister(User user) {
        userRepository.save(user);
        return "Registered Successfully";
    }

    @Override
    public String createNewPassword(String email, String password) {
        //check if email exits
        User value = userRepository.findByEmail(email);
        if(value==null){
            return "email does not exits";
        }else{
            userRepository.updatePassword(password, email);
            return "Password Updated Successfully";
        }
    }
}
