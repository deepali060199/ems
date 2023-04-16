package com.ems.controller;


import com.ems.model.EmployeeDetails;
import com.ems.model.EmployeeRating;
import com.ems.repository.IEmployeeRepository;
import com.ems.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

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



    @PostMapping("/create/employees")


    public EmployeeDetails saveEmployeeDetails(@RequestBody EmployeeDetails employeeDetails){

         return service.saveEmployeeDetails(employeeDetails);

    }

    @PutMapping("/employees/{empId}")
    @PreAuthorize("hasAuthority('ROLE_USER','ROLE_ADMIN')")
    public  EmployeeDetails updateEmployee(@PathVariable("empId")  long Id,@RequestBody EmployeeDetails employeeDetails){
        EmployeeDetails employeeDetail=repository.findById(Id).get();
        double rating= employeeDetail.getRating();

        EmployeeRating employeeRating=template.getForObject("http://employee-rating-service/v1/ratings/"+rating,EmployeeRating.class);

        int increment=employeeRating.getIncrement();
        int salary=employeeDetail.getSalary();
        employeeDetails.setSalary(salary+increment);
        return  service.updateEmployee(employeeDetails,Id);


    }

    @GetMapping("/employees/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<EmployeeDetails> getAllEmployee(){
      return repository.findAll();


    }

    @GetMapping("/employees/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")

    public  EmployeeDetails getById(@PathVariable("id") long id){
      return repository.findById(id).get();


    }


     @DeleteMapping("/employees/delete/{id}")
     @PreAuthorize("hasAuthority('ROLE_ADMIN')")
     public EmployeeDetails deleteEmployee(@PathVariable("id") long id){
        EmployeeDetails employeeDetails=repository.findById(id).get();
        repository.deleteById(id);

        return  employeeDetails;
     }


     @GetMapping("/employees/firstname/{firstname}")
     @PreAuthorize("hasAuthority('ROLE_USER')")

     public Optional<EmployeeDetails> getByFirstName(@PathVariable("firstname") String firstName){

    return repository.findByFirstName(firstName);


     }








}
