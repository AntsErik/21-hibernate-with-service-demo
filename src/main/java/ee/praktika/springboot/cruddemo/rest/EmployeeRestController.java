package ee.praktika.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ee.praktika.springboot.cruddemo.entity.Employee;
import ee.praktika.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping( "/api" )
public class EmployeeRestController {

    private EmployeeService employeeService;

    //inject employee DAO directly
    @Autowired
    public EmployeeRestController( EmployeeService theEmployeeService ) {
        employeeService = theEmployeeService;
    }

    //expose "/employees" endpoint and return all the employees
    @GetMapping( "/employees" )
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
}
