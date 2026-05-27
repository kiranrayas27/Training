package com.msedcl.main;

import com.msedcl.Sales.CalculateSales;

public class SalesMain {
	
	public static void main(String args[]) {
		final float totUnits=100;
		final float costPerUnit=8;
		final  float gst=0.18F;
		
		printMessage((totUnits1)->totUnits1*costPerUnit,totUnits,"Total Units Cost");
		printMessage((totUnits1)->(totUnits1*costPerUnit)*gst,totUnits,"GST Amount");
		printMessage((totUnits1)->((totUnits1*costPerUnit)*gst)+(totUnits1*costPerUnit),totUnits,"Final Bill");
		
	}
	
	public static void printMessage(CalculateSales calculateSales,float totUnits,String message) {
		System.out.println(message+ " : "+calculateSales.calculateAmount(totUnits));
	}
}
