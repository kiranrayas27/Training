package com.msedcl.main;

import com.msedcl.main.domain.Calculation;

//Pass lambda Expression as a parameter
public class LambdaPassParamMain {
 public static void main(String args[]) {
	 printMessage((n1,n2)->n1+n2,10,20);
	 printMessage((n1,n2)->n1-n2,10,20);
	 printMessage((n1,n2)->n1*n2,10,20);
	 printMessage((n1,n2)->n1/n2,10,20);
	 
}
 public static void printMessage(Calculation calculation, double numberOne,double  numberTwo) {
	System.out.println("Result of "+numberOne+ " and "+numberTwo + " is "+calculation.doCalculations(numberOne, numberTwo));
 }
}
