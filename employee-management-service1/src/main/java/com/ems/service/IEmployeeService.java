package com.ems.service;

import com.ems.model.EmployeeDetails;

public interface IEmployeeService {

    EmployeeDetails updateEmployee(EmployeeDetails employeeDetails,long Id);

    EmployeeDetails saveEmployeeDetails(EmployeeDetails employeeDetails);
}
