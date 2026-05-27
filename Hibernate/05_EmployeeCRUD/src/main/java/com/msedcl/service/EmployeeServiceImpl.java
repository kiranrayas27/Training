package com.msedcl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	@Override
	public Employee addNewEmployee(Employee employee) {
		return employeeRepository.addNewEmployee(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.updateEmployee(employee);
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		return employeeRepository.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		return employeeRepository.deleteEmployeeByEmployeeId(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
	
	@Override
	public List<Employee> getEmployeeByName(String name){
		return employeeRepository.getEmployeeByName(name);
	}

	@Override
	public long getCountOfEmployees() {
		return employeeRepository.getCountOfEmployees();
	}
	
	
	public List<Employee> findHighestSalaryEmployee(){
		return employeeRepository.findHighestSalaryEmployee();
	}

}
