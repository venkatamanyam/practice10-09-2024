package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EmployeeDTO;
import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
public class EmployeeContoller {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllEmps() {
                System.out.println("I am  C Branch");
		List<Employee> allEmps = empService.showAllEmps();
		
		return new ResponseEntity<List<Employee>>(allEmps, HttpStatus.OK);
	}

	@GetMapping("/showEmpl/{id}")
	public ResponseEntity<?> getEmp(@PathVariable Integer id) {
		System.out.println(id+" :");

		Employee emp = empService.showEmp(id);
		
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveEmp(@RequestBody Employee emp) {
		
		empService.saveEmp(emp);

		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateEmp(@RequestBody EmployeeDTO emp) {
		
		System.out.println("hellow");
		
		empService.updateEmployee(emp);

		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmp(@PathVariable Integer id) {
		
		empService.deleteEmployee(id);

		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
}
