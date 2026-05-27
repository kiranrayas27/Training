package com.msedcl.main;

import java.util.Scanner;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeCRUDMain {
	public static void main(String[] args) {
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
			System.out.println("5. Update a single field of an Employee");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Name");
				name = scanner.next();
				System.out.println("Enter Salary");
				salary = scanner.nextDouble();
				Employee employee = new Employee(0, name, salary);
				addNewEmployee(employee);
				break;
			case 2:
				System.out.println("Enter Employee Id");
				employeeId = scanner.nextInt();
				getEmployeeByEmployeeId(employeeId);
				break;
			case 3:
				System.out.println("Enter Employee Id");
				employeeId = scanner.nextInt();
				deleteByEmployeeId(employeeId);
				break;
			case 4:
				System.out.println("Enter Name");
				name = scanner.next();
				System.out.println("Enter Salary");
				salary = scanner.nextDouble();
				System.out.println("Enter the Id that is to be updated");
				employeeId = scanner.nextInt();
				Employee employee1 = new Employee(0, name, salary);
				updateByEmployeeId(employee1, employeeId);
				break;
			case 5:
				System.out.println("A.Update Name");
				System.out.println("B.Update Salary");
				subChoice = scanner.next();

				System.out.println("Enter the Id that is to be updated");
				employeeId = scanner.nextInt();

				switch (subChoice) {
				case "A":
					System.out.println("Enter new name : ");
					name = scanner.next();
					employee1 = new Employee(employeeId, name, 0);
					updateAFieldByEmployeeId(employee1);
					break;
				case "B":
					System.out.println("Enter new salary : ");
					salary = scanner.nextDouble();
					employee1 = new Employee(employeeId, "", salary);
					updateAFieldByEmployeeId(employee1);
					break;
				default:
					System.out.println("Invalid Choice");
				}
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue?");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));

	}

	public static void addNewEmployee(Employee employee) {
		// 1.Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2.Create Transaction object
		EntityTransaction entityTransaction = entityManager.getTransaction();

		// 3.Start Transaction
		entityTransaction.begin();

		// 4. Save employee object into database
		entityManager.persist(employee);

		// 5.Commit Transaction
		entityTransaction.commit();

		// 6.Close EntityManager
		entityManager.close();

		System.out.println("Employee created with employee Id " + employee.getEmployeeId());
	}

	public static Employee getEmployeeByEmployeeId(int employeeId) {
		// 1.Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2.Get Employee from DB
		Employee employee = entityManager.find(Employee.class, employeeId);
		if (employee != null)
			System.out.println(employee);
		else
			System.out.println("Invalid EmployeeId");

		// 3.Close EntityManager
		entityManager.close();
		return employee;
	}

	public static void deleteByEmployeeId(int employeeId) {
		// 1.Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2.Get Employee from DB
		Employee employee = entityManager.find(Employee.class, employeeId);
		if (employee != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			// 3.remove
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			System.out.println("Employee deleted successfully.");
		} else
			System.out.println("Invalid EmployeeId");

		// 4.Close EntityManager
		entityManager.close();

	}

	public static void updateByEmployeeId(Employee newEmployee, int employeeId) {
		// 1.Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2.Get Employee from DB
		Employee employee = entityManager.find(Employee.class, employeeId);
		if (employee != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			// 3.update
			entityTransaction.begin();
			newEmployee.setEmployeeId(employeeId);
			entityManager.merge(newEmployee);
			entityTransaction.commit();
			System.out.println("Employee updated successfully.");
		} else
			System.out.println("Invalid EmployeeId");

		// 4.Close EntityManager
		entityManager.close();

	}

	public static void updateAFieldByEmployeeId(Employee newEmployee) {
		// 1.Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2.Get Employee from DB
		Employee employee = entityManager.find(Employee.class, newEmployee.getEmployeeId());
		if (employee != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			// 3.update
			entityTransaction.begin();
			if (!newEmployee.getName().equals(""))
				employee.setName(newEmployee.getName());
			else if (newEmployee.getSalary() > 0)
				employee.setSalary(newEmployee.getSalary());
			entityTransaction.commit();
			System.out.println("Employee updated successfully.");
		} else
			System.out.println("Invalid EmployeeId");

		// 4.Close EntityManager
		entityManager.close();

	}
}
