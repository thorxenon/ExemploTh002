package com.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.JpaRepository.DepartmentRepository;
import com.model.Department;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentRepository repository;
    
    @GetMapping("/departments")
    public String getAllDepartments(Model model){
        model.addAttribute("departments", repository.findAll());
        return "departments_list";
    }

    @GetMapping("/departments/delete")
    public String delete(Model model, Integer id){
        repository.deleteById(id);
        model.addAttribute("departments", repository.findAll());
        return "departments_list";
    }

    @GetMapping("/departments/create")
    public String create(Model model){
        model.addAttribute("departments", new Department());
        return "departments_data";
    }

    @GetMapping("/departments/create/{id}")
    public String create(Model model, @PathVariable Integer id){
        Department depart = repository.findById(id).get();
        model.addAttribute("departs", depart);
        return "departments_data";
    }

    @PostMapping("/departments/create")
    public String create(Model model, @ModelAttribute Department depart){
        repository.save(depart);
        model.addAttribute("departments", repository.findAll());
        return "departments_list";
    }
}
