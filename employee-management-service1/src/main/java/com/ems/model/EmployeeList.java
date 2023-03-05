package com.ems.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeList {

  private  List<EmployeeDetails> employeeDetailsList=new ArrayList<>() ;


}
