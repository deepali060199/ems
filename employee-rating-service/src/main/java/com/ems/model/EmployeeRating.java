package com.ems.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class EmployeeRating {

    @Id
    private  double rating;
    private int increment;
}
