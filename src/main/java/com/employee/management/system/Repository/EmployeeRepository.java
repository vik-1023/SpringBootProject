package com.employee.management.system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.management.system.Entity.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long> {

}
