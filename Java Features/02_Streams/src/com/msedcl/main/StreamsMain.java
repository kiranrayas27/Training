package com.msedcl.main;

import java.util.Arrays;
import java.util.List;

import com.msedcl.main.domain.Person;

public class StreamsMain {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Shamal", "Snehal", "Prajakta","Supriya");

		// Print all except Supriya(without streams)
		for (String str : names) {
			if (!str.equalsIgnoreCase("Supriya"))
				System.out.println(str);
		}

		// Print all except Supriya(with streams)
		names.stream().filter((name)->!name.equals("Supriya")).forEach((name)->System.out.println(name));
		
		
		//////////////////////
		Person person1 = new Person("Vivek", "Gohil", 36);
		Person person2 = new Person("Trupti", "Acharekar", 38);
		Person person3 = new Person("Samarth", "Patil", 10);
		Person person4 = new Person("Grubux", "Gill", 30);
		
		//Print first name and last name of a person except Samarth
		List <Person> people=Arrays.asList(person1,person2,person3,person4);
		people.stream().filter((p)->!p.getFirstname().equals("Samarth")).forEach((p)->System.out.println(p.getFirstname()+" "+p.getLastname()));
	}

}
