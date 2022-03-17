package com.example.serviceImpl;

import com.example.model.Budget;
import com.example.repository.BudgetRepository;
import com.example.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    BudgetRepository budgetRepository;


    @Override
    public double monthlyCalculation(String month) {
        List<Double> amounts =budgetRepository.findAllByMonth(month);
        System.out.println(amounts.toString());
        double sum =0;
        for(Double i : amounts)
            sum = sum +i;
        return sum;    }

    @Override
    public double individualCalculation(String owner) {
        List<Double> total =budgetRepository.ownerMonth(owner);
        double ownersum =0;
        for(Double i : total) {
            ownersum += i;
        }
        return ownersum;
    }

    @Override
    public String newBudgetAdd(Budget budget){
        budgetRepository.save(budget);
        return "BudgetService Added Successfully";
    }
}
