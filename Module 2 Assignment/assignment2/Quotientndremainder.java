package assignment2;

import java.util.Scanner;

public class Quotientndremainder {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the dividend :");
		
		int dividend=sc.nextInt();
		
		System.out.println("Enter the divisor :");
		
		int divisor=sc.nextInt();
		
		int quotient=dividend/divisor;
		
		int remainder=dividend*divisor;
		
		
		System.out.println("quotient = " + quotient + " remainder = " + remainder);
		
		
		
		
	}

}
