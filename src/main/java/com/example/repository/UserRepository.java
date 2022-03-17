package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String email);
    @Modifying
    @Query("UPDATE User set password = ?1 where email = ?2" )
    void updatePassword(String password, String email);
}