package com.example.repository;

import com.example.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BudgetRepository extends CrudRepository<Budget, Integer> {

    @Modifying
    @Query("select amount from Budget Where month =?1 ")
    List<Double> findAllByMonth(String month);

    @Modifying
    @Query("select amount from Budget Where owner =?1 ")
    List<Double> ownerMonth(String owner);
}
