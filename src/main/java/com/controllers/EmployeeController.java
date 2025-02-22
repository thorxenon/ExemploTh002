package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.JpaRepository.EmployeeRepository;
import com.model.Employee;

@Controller
public class EmployeeController {

    
    @Autowired
    EmployeeRepository repository;


    @GetMapping("/employees/create/{matriculation}")
    public String create(Model model, @PathVariable String matriculation){
        Employee employee = repository.findById(matriculation).get();
        model.addAttribute("employee", employee);
        return "employee_data";
    }
}
