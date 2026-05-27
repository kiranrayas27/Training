package com.msedcl.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.entity.Employee;
import com.msedcl.service.EmployeeService;
import com.msedcl.service.EmployeeServiceImpl;
///////////////////////////////////////////////////
/// DEMONSTRATES SPRING JDBC////////
/// //////////////////////////////////////////////
public class EmployeeCRUDMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.msedcl");
		EmployeeService employeeService=applicationContext.getBean(EmployeeServiceImpl.class);
		Scanner scanner = new Scanner(System.in);
		int employeeId, choice;
		String name, continueChoice, subChoice;
		double salary;

		do {
			System.out.println("Menu");
			System.out.println("1. Add New Employee");
			System.out.println("2. Search Employee");
			System.out.println("3. Delete Employee");
			System.out.println("4. Update all fields of an Employee");
			System.out.println("5. Select all employees");
			System.out.println("6. Search Employee by Employee name");
			System.out.println("7. Print total Employees");
			System.out.println("8. Find highest salary employee");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Name");
				name = scanner.next();
				System.out.println("Enter Salary");
				salary = scanner.nextDouble();
				Employee employee = new Employee(0, name, salary);
				if(employeeService.addNewEmployee(employee)!=null) 
					System.out.println("New employee added successfully.");
				else
					System.out.println("Cannot add new Employee");
				break;
			case 2:
				System.out.println("Enter Employee Id");
				employeeId = scanner.nextInt();
				employee=employeeService.getEmployeeByEmployeeId(employeeId);
				if(employee!=null)
					System.out.println(employee);
				break;
			case 3:
				System.out.println("Enter Employee Id");
				employeeId = scanner.nextInt();
				if(employeeService.deleteEmployeeByEmployeeId(employeeId)) 
					System.out.println("Employee deleted successfully.");
				else
					System.out.println("Cannot delete Employee");
				break;
			case 4:
				System.out.println("Enter Name");
				name = scanner.next();
				System.out.println("Enter Salary");
				salary = scanner.nextDouble();
				System.out.println("Enter the Id that is to be updated");
				employeeId = scanner.nextInt();
				Employee employee1 = new Employee(employeeId, name, salary);
				if(employeeService.updateEmployee(employee1)!=null)
					System.out.println("Employee updated");
				else
					System.out.println("Cannot update employee.");
				break;
			case 5:
				List l=employeeService.getAllEmployees();
				l.forEach(e->System.out.println(e));
				break;
			case 6:
				System.out.println("Enter Name to search");
				name = scanner.next();
				l=employeeService.getEmployeeByName(name);
				l.forEach(e->System.out.println(e));
				break;
			case 7:
				System.out.println("Total Employees : "+employeeService.getCountOfEmployees());
				break;
			case 8:
				l=employeeService.findHighestSalaryEmployee();
				l.forEach(e->System.out.println(e));
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue?");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));

	}

	
}
