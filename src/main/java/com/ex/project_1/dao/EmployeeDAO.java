package com.ex.project_1.dao;

import com.ex.project_1.model.Employee;

import java.util.List;

/**
 * Interface for Data Access Objects to handle database queries
 * for Employees
 */

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeByEmail(String email);
    public Employee getEmployeeById(int id);
    public boolean authenticate(String email, String password);

    public boolean addEmployee(Employee employee);
    public boolean deleteEmployee(String email);

}
