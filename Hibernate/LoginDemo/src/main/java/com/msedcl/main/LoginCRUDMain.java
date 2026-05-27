package com.msedcl.main;

import java.util.Scanner;

import com.msedcl.bean.LoginDTO;
import com.msedcl.demo.HibernateUtil;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class LoginCRUDMain {
	public static void main(String[] args) {
		System.out.println("Enter User ID :");
		Scanner scanner = new Scanner(System.in);
		int loginId=scanner.nextInt();
		getValidLogin(loginId);
		
	}
	
	
	public static void getValidLogin(int loginId) {
		
		Scanner scanner = new Scanner(System.in);
		String password;
		// 1.Create EntityManager object
				EntityManager entityManager = HibernateUtil.getEntityManager();

				// 2.Get Employee from DB
				LoginDTO loginDTO = entityManager.find(LoginDTO.class, loginId);
				if (loginDTO != null)
				{
					if(loginDTO.getStatus().equalsIgnoreCase("ACTIVE"))
					{
						System.out.println("User is valid. Please enter password : ");
						password=scanner.next();
						
						if(loginDTO.getPassword().equals(password))
							System.out.println("Welcome User "+loginId+"!");
						else
						{
							System.out.println("Incorrect password");
							updateLoginCount(loginDTO);
						}
					}
					else
						System.out.println("User is blocked. Contact admin.");
				}
				else
					System.out.println("Invalid Login Id");

				// 3.Close EntityManager
				entityManager.close();
	}
	
	
	public static void updateLoginCount(LoginDTO loginDTO) {
		// 1.Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2.Get Employee from DB
		LoginDTO loginDTO1 = entityManager.find(LoginDTO.class, loginDTO.getLogin_id());
		if (loginDTO != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			// 3.update
			entityTransaction.begin();
			loginDTO1.setInvalid_login_count(loginDTO1.getInvalid_login_count()+1);
			entityTransaction.commit();
			if(loginDTO1.getInvalid_login_count()==3) {
				blockUser(loginDTO1);
			}
			else
			System.out.println((3-loginDTO1.getInvalid_login_count())+" attempts left.");
		} else
			System.out.println("Invalid Login Id");

		// 4.Close EntityManager
		entityManager.close();

	}
	
	
	
	public static void blockUser(LoginDTO loginDTO) {
		// 1.Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2.Get Employee from DB
		LoginDTO loginDTO1 = entityManager.find(LoginDTO.class, loginDTO.getLogin_id());
		if (loginDTO != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			// 3.update
			entityTransaction.begin();
			loginDTO1.setStatus("Blocked");
			entityTransaction.commit();
			System.out.println("User is blocked. Contact Admin.");
		} else
			System.out.println("Invalid Login Id");

		// 4.Close EntityManager
		entityManager.close();

	}

		
}


