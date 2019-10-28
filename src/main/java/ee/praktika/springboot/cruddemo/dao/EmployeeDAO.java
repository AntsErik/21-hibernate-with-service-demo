package ee.praktika.springboot.cruddemo.dao;

import java.util.List;

import ee.praktika.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

    public List<Employee> findAll();
}
