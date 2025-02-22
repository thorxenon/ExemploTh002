package com.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
    @Id
    private String matriculation;
    private String name;
    private Date enrollDate;


    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Department department;

    public Employee(){}

    public String getMatriculation(){
        return matriculation;   
    }

    public void setMatriculation(String matriculation){
        this.matriculation = matriculation;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Date getEnrollDate(){
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate){
        this.enrollDate = enrollDate;
    }
}
