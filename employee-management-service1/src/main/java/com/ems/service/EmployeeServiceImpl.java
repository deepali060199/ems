package com.ems.service;

import com.ems.model.EmployeeDetails;
import com.ems.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl  implements  IEmployeeService{

    @Autowired
    IEmployeeRepository repository;
    @Override
    public EmployeeDetails updateEmployee(EmployeeDetails employeeDetails, long Id) {
        // old object
        EmployeeDetails employee=repository.findById(Id).get();
        String address=employeeDetails.getAddress();
        int salaryGarde=employeeDetails.getSalary();
        double rating=employeeDetails.getRating();
        String city= employeeDetails.getCity();
        String email= employeeDetails.getEmail();
        String lastName=employeeDetails.getLastName();
        String firstName=employeeDetails.getFirstName();
        if(address==null || address.equals("")){
            address=employee.getAddress();
        }

        if(salaryGarde==0){
            salaryGarde=employee.getSalary();
        }
        if(rating==0.0){
            rating=employee.getRating();
        }

<<<<<<<<< Temporary merge branch 1
        repository.updateEmployeeDetails(Id,address,salaryGarde,rating,firstName);
=========
        repository.updateEmployeeDetails(Id,address,salaryGarde,rating,firstName,lastName,email,city);
>>>>>>>>> Temporary merge branch 2
        return repository.findById(Id).get();
    }
}
