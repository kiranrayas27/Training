package com.msedcl.main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.Comparator;

import com.msedcl.main.domain.Condition;
import com.msedcl.main.domain.Person;

public class PersonMain {
	public static void main(String args[]) {
		Person person1 = new Person("Vivek", "Gohil", 36);
		Person person2 = new Person("Trupti", "Acharekar", 38);
		Person person3 = new Person("Samarth", "Patil", 10);
		Person person4 = new Person("Grubux", "Gill", 30);

		List<Person> people = Arrays.asList(person1, person2, person3, person4);

		for (Person person : people) {
			System.out.println(person);
		}
		/**** Without Lambda Expresion ***********/
		///////////////
		people.sort(new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getLastname().compareTo(p2.getLastname());
			}
		});

		System.out.println("After sorting:-");
		for (Person person : people) {
			System.out.println(person);
		}
		///////
		System.out.println("Person's with last name starting with G:-");
		for (Person p : people) {
			if (p.getLastname().startsWith("G")) {
				System.out.println(p);
			}
		}

		///////
		System.out.println("Person's with last name ending with l:-");
		for (Person p : people) {
			if (p.getLastname().endsWith("l")) {
				System.out.println(p);
			}
		}
		
		/*******With lambda Expression*******/
		people.sort((p1,p2) -> p1.getLastname().compareTo(p2.getLastname()));
		System.out.println("After sorting(using lambda expresion):-");
		for (Person person : people) {
			System.out.println(person);
		}
		/////
		System.out.println("People with last name starting with G(using lambda expresion):-");
		printConditionally(people,(p,startsWithChar)->p.getLastname().startsWith(startsWithChar),"G",(p)->System.out.println(p.getLastname()),(p)->p.getLastname().endsWith("l"));
		
			
	}
	
	public static void printConditionally(List<Person> pList,Condition condition, String startsWithChar,Consumer<Person> consumer, Predicate<Person> predicate) {
		for (Person person : pList) {
			if(condition.test(person, startsWithChar))
				System.out.println(person);
			
			if(predicate.test(person))//Predicate is same as our Condition class
				consumer.accept(person);
		}
	}
}
