package com.ems.repository;

import com.ems.model.EmployeeRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository  extends JpaRepository<EmployeeRating,Double> {
}
