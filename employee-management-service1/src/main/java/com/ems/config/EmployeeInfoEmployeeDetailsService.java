package com.ems.config;

import com.ems.model.EmployeeDetails;
import com.ems.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class EmployeeInfoEmployeeDetailsService implements UserDetailsService {

    @Autowired
       IEmployeeRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Optional<EmployeeDetails> employeeDetails=repository.findByFirstName(username);
        System.out.println(employeeDetails);
       return  employeeDetails.map(UserInfoUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("username not found "+username));
    }
}
