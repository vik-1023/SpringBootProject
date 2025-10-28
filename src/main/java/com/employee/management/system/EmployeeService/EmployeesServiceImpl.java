package com.employee.management.system.EmployeeService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.management.system.Entity.Employees;
import com.employee.management.system.Exception.ResourceNotFoundException;
import com.employee.management.system.Repository.EmployeeRepository;

@Service
public class EmployeesServiceImpl  implements EmployeeSevice{
	

	private final EmployeeRepository employeeRepository;
	
	public EmployeesServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}

	@Override
	public Employees addEmployee(Employees emp) {
		
		return employeeRepository.save(emp);
	}

	@Override
	public List<Employees> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employees getEmployeesById(Long id) {
		Employees emp=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee not found with id :"+id));
		return emp;
	}

	@Override
	public Employees updateEmployees(Long id, Employees emp) {
		Employees employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with :"+id));
		employee.setAddress(emp.getAddress());
		employee.setDepartment(emp.getDepartment());
		employee.setEmail(emp.getEmail());
		employee.setName(emp.getName());
		employee.setPhone(emp.getPhone());
		employee.setSalary(emp.getSalary());
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		if(!employeeRepository.existsById(id)) {
			System.out.println("Employee not found with :"+id);
			return;
		}
		employeeRepository.deleteById(id);
		
		
	}

	@Override
	public Employees updateEmployeeSingleField(Long id, Employees emp) {
		
		Employees employees=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with id :"+id));
		if(employees.getAddress()!=null) {
			emp.setAddress(emp.getAddress());
		}
		if(emp.getDepartment()!=null) {
			employees.setDepartment(emp.getDepartment());
		}
		if(emp.getEmail()!=null) {
			employees.setEmail(emp.getEmail());
		}
		
		if(emp.getName()!=null) {
			employees.setName(emp.getName());
		}
		
		if(emp.getPhone()!=null) {
			employees.setPhone(emp.getPhone());
		}
		
		if(emp.getSalary()!=0) {
			employees.setSalary(emp.getSalary());
		}
		
		return employeeRepository.save(employees);
	
	}

	@Override
	public List<Employees> addMultipleEmployee(List<Employees> emp) {
		
		return employeeRepository.saveAll(emp);
	}

}
