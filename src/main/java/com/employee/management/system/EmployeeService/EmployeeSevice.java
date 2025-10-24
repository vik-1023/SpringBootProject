package com.employee.management.system.EmployeeService;

import java.util.List;

import com.employee.management.system.Entity.Employees;

public interface EmployeeSevice {
	
	Employees addEmployee(Employees emp);
	
	List<Employees>getAllEmployees();
	
	Employees getEmployeesById(Long id);
	
	Employees updateEmployees(Long id,Employees emp);
	
	void deleteEmployeeById(Long id);
	
	Employees updateEmployeeSingleField(Long id ,Employees emp);
	
	

}
