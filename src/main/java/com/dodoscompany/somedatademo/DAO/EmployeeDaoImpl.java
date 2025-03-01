package com.dodoscompany.somedatademo.DAO;

import com.dodoscompany.somedatademo.entities.Employee;
import com.dodoscompany.somedatademo.exceptions.EmployeeException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
      return   entityManager.merge(employee);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e  ", Employee.class);
        List<Employee> list= query.getResultList();
        if(list.isEmpty()){
            throw new EmployeeException("Employees not found");
        }else {
            return list;
        }
    }

    @Override
    public Employee findById(int id) {
        Employee employee= entityManager.find(Employee.class,id);
        if(employee!=null){
            return employee;
        }else {
           throw new EmployeeException("Employee not found with id "+id);
        }

    }

    @Override
    @Transactional
    public void removeEmployeeById(int id) {
       Employee employee=findById(id);
         if(employee!=null){
              entityManager.remove(employee);
         }
    }
}
