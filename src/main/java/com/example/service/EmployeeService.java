package com.example.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.EmployeeDTO;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;

	public boolean saveEmp(Employee emp) {
		
		
		empRepo.save(emp);
		
		
		return true;
		
	}

	public List<Employee> showAllEmps() {
		
		return empRepo.findAll();
		
	}

	public Employee showEmp(Integer id) {
		
		return empRepo.findById(id).get();
		
	}

	public boolean updateEmployee( EmployeeDTO emp) {
		

		Employee employee=new Employee();
		
		BeanUtils.copyProperties(emp, employee);
		
		empRepo.save(employee);
		
		
		
		return true;
	}

	public boolean deleteEmployee(Integer id) {
		
		empRepo.deleteById(id);
		
		
       return true;		
	}
	
	

}
