package com.msedcl.main;

import com.msedcl.main.domain.Calculation;

public class CalculationsMain {

	public static void main(String[] args) {
		Calculation calculation = null;
		
		calculation = (double numberOne, double numberTwo) -> {
			return numberOne + numberTwo;
		};
		double addition_result=calculation.doCalculations(50.1,90.9);
		System.out.println("Addition is : "+addition_result);
		
		calculation = (double numberOne, double numberTwo) -> {
			return numberOne - numberTwo;
		};
		double subtraction_result=calculation.doCalculations(90.96,30.39);
		System.out.println("Subtraction is : "+subtraction_result);
		
		calculation = (double numberOne, double numberTwo) -> {
			return numberOne * numberTwo;
		};
		double multiplication_result=calculation.doCalculations(50,5);
		System.out.println("Multiplication is : "+multiplication_result);
		
		calculation = (double numberOne, double numberTwo) -> {
			return numberOne / numberTwo;
		};
		double division_result=calculation.doCalculations(50,5);
		System.out.println("Division is : "+division_result);
		
		
		/////////////////////////////////////////////////////////////
		calculation=(n1,n2)->n1*n2;
		System.out.println("Multipliaction : "+calculation.doCalculations(1, 5));
		
		calculation=(n1,n2)->n1/n2;
		System.out.println("Multipliaction : "+calculation.doCalculations(500, 10));
		
		///////////////////////////////////////////////////////////////
		calculation=new Calculation() {
			

			@Override
			public double doCalculations(double numberOne, double numberTwo) {
				// TODO Auto-generated method stub
				return numberOne*numberTwo;
			}
		};
	}

}
