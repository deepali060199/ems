package com.ems.controller;


import com.ems.model.EmployeeRating;
import com.ems.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins ="*")
public class RatingController {

    @Autowired
    IEmployeeRepository repository;

    @PostMapping("/ratings")
    public EmployeeRating saveRating(@RequestBody EmployeeRating employeeRating){
        repository.save(employeeRating);
        return  employeeRating;
    }

    @GetMapping("/ratings/{rating}")
    public  EmployeeRating getRating(@PathVariable("rating") double rating){
      return   repository.findById(rating).get();

    }




}
