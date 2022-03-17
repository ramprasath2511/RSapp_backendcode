package com.example.controller;

import com.example.model.Budget;
import com.example.model.User;
import com.example.service.BudgetService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RSController {

    @Autowired
    UserService userService;

    @Autowired
    BudgetService budgetService;


    @GetMapping("/details")
    public List<User> getDetails() {
      return userService.loginDetails();
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
       return userService.newRegister(user);
    }

    @PutMapping("/forgotpassword")
    public String forgotPassword(@RequestParam String email, @RequestParam String password){
      return  userService.createNewPassword(password,email);
    }

    @PostMapping("/addbudget")
    public String addBudget(@RequestBody Budget budget){
        return budgetService. newBudgetAdd(budget);
    }

    @GetMapping("/home")
    public double monthlyTotal(@RequestParam String month){
       return budgetService.monthlyCalculation(month);
    }

    @GetMapping("/ownertotal")
    public double ownerTotal(@RequestParam String owner){
       return budgetService.individualCalculation(owner);
    }

}
