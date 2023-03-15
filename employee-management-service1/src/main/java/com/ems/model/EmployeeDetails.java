package com.ems.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;




@Entity

@Data
public class EmployeeDetails {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private int salary;
    private String address;
    private double rating;
    private String city;
    private String email;
    private String state;
    private int age;
    private String gender;

}
