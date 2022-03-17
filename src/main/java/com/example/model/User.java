package com.example.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Component
@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column(name = "profile_pic")
    private String profilePic;
}
