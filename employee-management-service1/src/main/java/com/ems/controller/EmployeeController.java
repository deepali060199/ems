package com.ems.controller;


import com.ems.model.EmployeeDetails;
import com.ems.model.EmployeeRating;
import com.ems.repository.IEmployeeRepository;
import com.ems.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1")

public class EmployeeController {


      @Autowired
       private IEmployeeRepository repository ;




    @Autowired
    RestTemplate template;

    @Autowired
    IEmployeeService service;



    @PostMapping("/employees")
    public EmployeeDetails saveEmployeeDetails(@RequestBody EmployeeDetails employeeDetails){

        repository.save(employeeDetails);
        return  employeeDetails;

    }

    @PutMapping("/employees/{empId}")
    public  EmployeeDetails updateEmployee(@PathVariable("empId")  long Id,@RequestBody EmployeeDetails employeeDetails){
        EmployeeDetails employeeDetail=repository.findById(Id).get();
        double rating= employeeDetail.getRating();

        EmployeeRating employeeRating=template.getForObject("http://employee-rating-service/v1/ratings/"+rating,EmployeeRating.class);

        int increment=employeeRating.getIncrement();
        int salary=employeeDetail.getSalary();
        employeeDetails.setSalary(salary+increment);
        return  service.updateEmployee(employeeDetails,Id);


    }

    @GetMapping("/employees")
    public List<EmployeeDetails> getAllEmployee(){
      return repository.findAll();


    }

    @GetMapping("/employees/{id}")

    public  EmployeeDetails getById(@PathVariable("id") long id){
      return repository.findById(id).get();


    }


     @DeleteMapping("/employees/{id}")
    public EmployeeDetails deleteEmployee(@PathVariable("id") long id){
        EmployeeDetails employeeDetails=repository.findById(id).get();
        repository.deleteById(id);

        return  employeeDetails;
     }






}
