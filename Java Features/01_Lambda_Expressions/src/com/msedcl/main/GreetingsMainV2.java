package com.msedcl.main;

import com.msedcl.main.domain.GoodMorning;
import com.msedcl.main.domain.Greetings;

public class GreetingsMainV2 {
	public static void main(String args[]) {
		printMessage(new GoodMorning());
		
		printMessage(()->System.out.println("Have a nice day"));
	}
	
	public static void printMessage(Greetings greeting) {
		greeting.greet();
	 }
}
