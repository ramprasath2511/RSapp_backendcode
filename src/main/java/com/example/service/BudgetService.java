package com.example.service;

import com.example.model.Budget;
import org.springframework.stereotype.Service;

@Service
public interface BudgetService  {

    double monthlyCalculation(String month);
    double individualCalculation(String owner);
    String newBudgetAdd(Budget budget);
}

