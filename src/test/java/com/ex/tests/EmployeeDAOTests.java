package com.ex.tests;

import com.ex.project_1.dao.EmployeeDAOImpl;
import com.ex.project_1.model.Employee;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class EmployeeDAOTests {

    EmployeeDAOImpl eDao = new EmployeeDAOImpl();

    @Test
    public void shouldCreateEmployee() {
        Assert.assertTrue(eDao.addEmployee(new Employee(
                "Myles",
                "Garrett",
                "mg@test.com",
                "pw"
        )));
    }

    @Test
    public void shouldDeleteEmployee() {
        Assert.assertTrue(eDao.deleteEmployee("mg@test.com"));
    }

    @Test
    public void shouldGetEmployeeByEmail() {
        eDao.getEmployeeByEmail("emp@test.com");
    }

    @Test
    public void shouldAuthenticate() {
        eDao.authenticate("emp@test.com", "password");
    }

    @Test
    public void shouldGetEmployeeById() {
        eDao.getEmployeeById(1);
    }

    @Test
    public void shouldGetAllEmployees() {
        List<Employee> employees = null;
        employees = eDao.getAllEmployees();
        Assert.assertNotNull(employees);
    }

    @Test
    public void shouldNotGetEmpByEmail() {
        Employee nullEmp = new Employee();
        nullEmp = eDao.getEmployeeByEmail("notEmail");
        Assert.assertNull(nullEmp);
    }
}
