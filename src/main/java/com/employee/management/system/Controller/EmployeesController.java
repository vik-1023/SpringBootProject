package com.employee.management.system.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.employee.management.system.EmployeeService.EmployeesServiceImpl;
import com.employee.management.system.Entity.Employees;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
	private EmployeesServiceImpl employeesServiceImpl;

	public EmployeesController(EmployeesServiceImpl employeesServiceImpl) {
		this.employeesServiceImpl = employeesServiceImpl;
	}

	@PostMapping("/create")
	public ResponseEntity<Employees> create(@RequestBody Employees employee) {

		return ResponseEntity.status(HttpStatus.CREATED).body(employeesServiceImpl.addEmployee(employee));
	}

	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employees>> getAllEmp() {
		return ResponseEntity.ok(employeesServiceImpl.getAllEmployees());
	}

	@GetMapping("getEmployeeById/{id}")
	public ResponseEntity<Employees> getSingleEmployee(@PathVariable Long id) {
		return ResponseEntity.ok(employeesServiceImpl.getEmployeesById(id));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateEmployeeAllField(@PathVariable Long id, @RequestBody Employees emp) {
		employeesServiceImpl.updateEmployees(id, emp);
		return ResponseEntity.ok("Employee updated successfully.. with :" + id);
	}

	@PatchExchange("/updateEmployeeField/{id}")
	public ResponseEntity<String> updateEmployeeSingleField(@PathVariable Long id, @RequestBody Employees emp) {
		employeesServiceImpl.updateEmployeeSingleField(id, emp);
		return ResponseEntity.ok("emplyees updated successfully with :" + id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		employeesServiceImpl.deleteEmployeeById(id);
		return ResponseEntity.ok("employee deleted successfully with :" + id);
	}
}
