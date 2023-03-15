package com.ems.repository;

import com.ems.model.EmployeeDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IEmployeeRepository extends JpaRepository<EmployeeDetails,Long> {

    @Transactional
    @Modifying
    @Query("update EmployeeDetails e set e.address=:address , e.salary=:salary,e.rating=:rating,e.firstName=:firstName where e.id=:Id")
    void updateEmployeeDetails(@Param("Id") long Id,@Param("address") String address, @Param("salary") int salary,@Param("rating") double rating ,@Param("firstName") String firstName);
}
