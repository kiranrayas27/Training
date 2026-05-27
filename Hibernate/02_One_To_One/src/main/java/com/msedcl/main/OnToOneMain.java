package com.msedcl.main;

import com.msedcl.main.entity.Address;
import com.msedcl.main.entity.User;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OnToOneMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//select();
		//insert();
		//update();
		//merge();
		//remove();
		//detach();
		refresh();
	}
	
	public static void refresh() {
	//object loaded in java from db
		//the record may be updted in DB externally
		//need to see the updated object
		EntityManager entityManager=HibernateUtil.getEntityManager();
		User existingUser=entityManager.find(User.class, 6);
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		existingUser.setName("Rahul Dravid");
		existingUser.getAddress().setCity("Navi Mumbai");
		
		System.out.println("After changes");
		System.out.println(existingUser);
		
		System.out.println("Refresh called");
		entityManager.refresh(existingUser);
		
		System.out.println("After Refresh");
		System.out.println(existingUser);
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	public static void detach() {
	//detach= Remove entity from persistence context
		//which means Hibernate stops tracking object changes
		
		EntityManager entityManager=HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		//object fetch
		User existingUser=entityManager.find(User.class, 6);
		System.out.println("before detach");
		System.out.println(existingUser);
		entityManager.detach(existingUser);
		existingUser.setName("Rahul Dravid");
		existingUser.getAddress().setCity("Thiruvananthapuram");
		entityTransaction.commit();
		entityManager.close();
		
		
		
	}
	
	public static void remove() {
		EntityManager entityManager=HibernateUtil.getEntityManager();
		User existingUser=entityManager.find(User.class, 4);
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(existingUser);
		entityTransaction.commit();
		entityManager.close();
	}
	
	public static void merge() {
		EntityManager entityManager=HibernateUtil.getEntityManager();
		
		User existingUser=entityManager.find(User.class, 1);
		System.out.println("Object fetched");
		System.out.println(existingUser);
		entityManager.close();
		System.out.println("Entity Manager closed");
		//At this point, state of object is detached
		existingUser.setName("Seema Rao");
		System.out.println("At this point, state of object is detached");
		System.out.println(existingUser);
		
		entityManager=HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(existingUser);
		entityTransaction.commit();
		entityManager.close();
		
	}
	
	public static void update() {
		//Address address=new Address(1,"Pune","400002");
		//User user=new User(1,"Ritika",address);
		EntityManager entityManager=HibernateUtil.getEntityManager();
		
		User user1=entityManager.find(User.class, 1);
		
	
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		user1.setAddress(new Address(1,"Nashik","400012"));
		user1.setName("rupali");
		entityManager.merge(user1);
		entityTransaction.commit();
		entityManager.close();
	}
	public static void insert() {
		Address address=new Address(0,"Navi Mumbai","412312");
		User user=new User(0,"Rahul",address);
		EntityManager entityManager=HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		entityManager.close();
	}
	public static void select() {
		EntityManager entityManager=HibernateUtil.getEntityManager();
		User user=entityManager.find(User.class, 1);
		System.out.println(user.getName()+" "+user.getAddress().getCity());
		entityManager.close();
	}
}
