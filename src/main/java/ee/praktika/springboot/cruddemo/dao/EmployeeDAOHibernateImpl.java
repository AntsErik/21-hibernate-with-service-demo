package ee.praktika.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ee.praktika.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    //define field for entity manager
    private EntityManager entityManager;

    //set up constructor injections.
    @Autowired
    public EmployeeDAOHibernateImpl( EntityManager theEntityManager ) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll(){

        //get the current session
        Session currentSession = entityManager.unwrap( Session.class );

        //create a query
        Query<Employee> theQuery = currentSession.createQuery( "from Employee", Employee.class );

        //execute the query and get the list
        List<Employee> employees = theQuery.getResultList();

        //return the results
        return employees;
    }
}