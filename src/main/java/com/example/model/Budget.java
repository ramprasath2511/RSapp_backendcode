package com.example.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Data
@Component
@Entity
@Table(name="budget", schema="public")

public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer Id;
    @Column
    private Date date;
    @Column
    private String description;
    @Column
    private double amount;
    @Column
    private String owner;
    @Column
    private String month;

}
