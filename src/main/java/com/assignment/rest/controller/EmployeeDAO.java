package com.assignment.rest.controller;

import org.springframework.stereotype.Component;

import com.assignment.rest.model.Employee;
import com.assignment.rest.model.Employees;
@Component
public class EmployeeDAO 
{
    private static Employees list = new Employees();
    
    static 
    {
        list.getEmployeeList().add(new Employee(1, "Lokesh", "Gupta", "assignment@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "David", "Kameron", "titanic@gmail.com"));
    }
    
    public Employees getAllEmployees() 
    {
        return list;
    }
    
    public Employee getEmployee() 
    {
        return list.getEmployeeList().get(0);
    }
    
    public String addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
        return "success";
    }
}
