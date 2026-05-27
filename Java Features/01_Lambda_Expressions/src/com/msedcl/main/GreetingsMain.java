package com.msedcl.main;

import com.msedcl.main.domain.*;

public class GreetingsMain {

	public static void main(String[] args) {
		Greetings greeting=new GoodMorning();
		greeting.greet();
		
		greeting=new GoodAfternoon();
		greeting.greet();
		
		greeting =new GoodEvening();
		greeting.greet();
		
		greeting= () -> {
			System.out.println("Good night all");
		};
		
		greeting.greet();
		
		
		
	}

}
