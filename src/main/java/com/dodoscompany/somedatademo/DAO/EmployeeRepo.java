package com.dodoscompany.somedatademo.DAO;

import com.dodoscompany.somedatademo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
