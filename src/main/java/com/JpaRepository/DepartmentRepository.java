package com.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
    
}