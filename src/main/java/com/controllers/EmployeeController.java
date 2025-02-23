package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.JpaRepository.DepartmentRepository;
import com.JpaRepository.EmployeeRepository;
import com.model.Employee;

@Controller
public class EmployeeController {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Autowired
    EmployeeRepository repository;

    @GetMapping("/employees")
    public String getAllEmployees(Model model){
        model.addAttribute("employees", repository.findAll());
        return "employees_list";
    }

    @GetMapping("/employee/create")
    public String create(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentRepository.findAll());
        return "employee_data";
    }


    @GetMapping("/employee/create/{matriculation}")
    public String create(Model model, @PathVariable String matriculation){
        Employee employee = repository.findById(matriculation).get();
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("employee", employee);
        return "employee_data";
    }

    @GetMapping("/employee/delete/{matriculation}")
    public String delete(Model model, @PathVariable String matriculation){
        repository.deleteById(matriculation);
        model.addAttribute("employees", repository.findAll());
        return "employees_list";
    }

    @PostMapping("/employees/create")
    public String createEmployee(Model model,  @ModelAttribute Employee employee){
        repository.save(employee);
        
        model.addAttribute("employees", repository.findAll());
        return "employees_list";
    }
}
