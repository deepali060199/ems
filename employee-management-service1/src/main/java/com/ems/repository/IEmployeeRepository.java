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
    @Query("update EmployeeDetails e set e.address=:address , e.salaryGrade=:salaryGrade,e.rating=:rating,e.name=:name where e.id=:Id")
    void updateEmployeeDetails(@Param("Id") long Id,@Param("address") String address, @Param("salaryGrade") int salaryGrade,@Param("rating") double rating ,@Param("name") String name);
}