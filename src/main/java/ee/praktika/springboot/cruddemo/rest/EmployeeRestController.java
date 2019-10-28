package ee.praktika.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ee.praktika.springboot.cruddemo.dao.EmployeeDAO;
import ee.praktika.springboot.cruddemo.entity.Employee;

@RestController
@RequestMapping( "/api" )
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    //inject employee DAO directly
    @Autowired
    public EmployeeRestController( EmployeeDAO theEmployeeDAO ) {
        employeeDAO = theEmployeeDAO;
    }

    //expose "/employees" endpoint and return all the employees
    @GetMapping( "/employees" )
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}
